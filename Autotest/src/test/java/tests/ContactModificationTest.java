package tests;

import objects.Contact;
import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class ContactModificationTest extends TestBase {

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;
    private String groupName;
    private GroupsPage groupsPage;

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

    @Test(description = "Тест, который модицицирует первый контакт в списке")
    public void testContactModification() {
        int contactsNumberBefore = mainPage.countContacts();
        Contact contact = generateRandomContact();
        addContactPage = mainPage.pressEditFirstContactBtn();
        addContactPage.fillContactCreationField(contact);
        addContactPage.pressUpdateBtn();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter, contactsNumberBefore,
                "Количество контактов не должно было измениться по результатам работаы теста");

    }

}
