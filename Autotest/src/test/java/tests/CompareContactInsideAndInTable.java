package tests;

import objects.Contact;
import objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static Utils.CustomObjectsGenerator.generateRandomGroup;

public class CompareContactInsideAndInTable extends TestBase {

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;
    private String groupName;

    @BeforeMethod
    public void loginMethod() {
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
    public void testCompareContactInsideAndInTable() {
        Contact contact = mainPage.getRandomContactFromTable();
        System.out.println(contact);
        addContactPage = mainPage.pressEditContact(contact);
        Contact contactFromEditForm = addContactPage.getContact();
        System.out.println(contactFromEditForm);
        Assert.assertEquals(contact, contactFromEditForm);
    }
}
