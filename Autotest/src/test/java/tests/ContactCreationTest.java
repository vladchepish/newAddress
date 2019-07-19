package tests;

import objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.CustomObjectsGenerator.generateRandomContact;
import static lib.Compares.CompareTwoIntValue;

public class ContactCreationTest extends TestBase{

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
    }

    @Test(description = "Тест, который создаёт контакт")
    public void testContactCreation(){
        int contactsNumberBefore = mainPage.countContacts();
        Contact contact = generateRandomContact();
        contact.setGroup("testName");
        addContactPage = navigation.openAddContactPage();
        addContactPage.fillContactCreationField(contact, true);
        addContactPage.pressEnterBtn();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter, contactsNumberBefore + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

    }

}
