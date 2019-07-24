package tests;

import objects.Contact;
import objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static java.util.Comparator.comparingInt;
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
        List<Contact> contactsBefore = mainPage.getContactList();
        File photo = new File("src/test/resources/photo.jpg");
        Contact contact = generateRandomContact();
        contact.setGroup(groupName);
        contact.setPhoto(photo);
        addContactPage = navigation.openAddContactPage();
        addContactPage.fillContactCreationField(contact, true);
        addContactPage.pressEnterBtn();
        navigation.openMainPage();
        List<Contact> contactsAfter = mainPage.getContactList();
        CompareTwoIntValue(contactsAfter.size(), contactsBefore.size() + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

        contact.setId(contactsAfter.stream().max(comparingInt(Contact::getId)).get().getId());
        contactsBefore.add(contact);
        Comparator<? super Contact> byId = Comparator.comparingInt(Contact::getId);
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsBefore, contactsAfter,
                "После выполнения теста и змены элементов - списки должны совпадать");

    }

}
