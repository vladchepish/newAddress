package tests;

import objects.Contact;
import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class ContactDeletionTest extends TestBase {

    private LoginPage loginPage;
    private MainPage mainPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;
    private AddContactPage addContactPage;
    private String groupName;

    @BeforeMethod
    public void loginMethod() {
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
        if (mainPage.countContacts() == 0) {
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
            Contact contact = generateRandomContact();
            contact.setGroup(groupName);
            addContactPage = navigation.openAddContactPage();
            addContactPage.fillContactCreationField(contact, true);
            addContactPage.pressEnterBtn();
            navigation.openMainPage();
        }
    }

    @Test(description = "Тест удаляющий первый контакт в таблице")
    public void testContactDeletion() {
        int contactsNumberBefore = mainPage.countContacts();
        mainPage.selectFirstContact();
        mainPage.pressDeleteBtn();
        mainPage.confirmDeletion();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter + 1, contactsNumberBefore,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");
    }
}
