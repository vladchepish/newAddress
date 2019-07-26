package tests;

import objects.Contact;
import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Comparator;
import java.util.List;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;
import static org.testng.Assert.assertEquals;

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
        List<Contact> contactsBefore = mainPage.getContactList();
        Contact contact = generateRandomContact();
        contact.setId(contactsBefore.get(0).getId());
        addContactPage = mainPage.pressEditFirstContactBtn();
        addContactPage.fillContactCreationField(contact);
        addContactPage.pressUpdateBtn();
        navigation.openMainPage();
        List<Contact> contactsAfter = mainPage.getContactList();
        CompareTwoIntValue(contactsAfter.size(), contactsBefore.size(),
                "Количество контактов не должно было измениться по результатам работаы теста");

        contactsBefore.remove(0);
        contactsBefore.add(contact);
        Comparator<? super Contact> byId = Comparator.comparingInt(Contact::getId);
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        assertEquals(contactsBefore, contactsAfter,
                "После выполнения теста и змены элементов - списки должны совпадать");
    }
}
