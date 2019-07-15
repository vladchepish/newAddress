package tests;

import objects.Contact;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.CustomObjectsGenerator.*;
import static lib.Compares.CompareTwoIntValue;

public class ContactCreationTest extends TestBase{

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;

    @Test
    public void testContactCreation(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
        int contactsNumberBefore = mainPage.countContacts();
        Contact contact = generateRandomContact();
        addContactPage = navigation.openAddContactPage()
                .fillContactCreationField(contact)
                .pressEnterBtn();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter, contactsNumberBefore + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

    }

}
