package tests;

import objects.Contact;
import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class ContactCreationTest extends TestBase{

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;
    private String groupName;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
        groupsPage = navigation.openGroupsPage();
        if (groupsPage.countGroups() == 0) {
            Group groupZero = generateRandomGroup();
            addGroupPage = groupsPage.pressAddNewGroupBtn();
            addGroupPage.fillGroupCreationFields(groupZero);
            successPage = addGroupPage.pressEnterInformationBtn();
            successPage.clickOnReturnLink();
        }
        groupName = groupsPage.getFirstGroupName();
        mainPage = navigation.openMainPage();
    }

    @Test(description = "Тест, который создаёт контакт")
    public void testContactCreation(){
        int contactsNumberBefore = mainPage.countContacts();
        Contact contact = generateRandomContact();
        contact.setGroup(groupName);
        addContactPage = navigation.openAddContactPage();
        addContactPage.fillContactCreationField(contact, true);
        addContactPage.pressEnterBtn();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter, contactsNumberBefore + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

    }

}
