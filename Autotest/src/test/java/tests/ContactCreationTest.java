package tests;

import objects.Contact;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.DataGenerator.generateString;
import static Utils.DataGenerator.geniratorNumeric;
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
        addContactPage = navigation.openAddContactPage()
                .fillContactCreationField(new Contact().generateRandomContact())
                .pressEnterBtn();
        navigation.openMainPage();
        int contactsNumberAfter = mainPage.countContacts();
        CompareTwoIntValue(contactsNumberAfter, contactsNumberBefore + 1,
                "Количество контактов до должно быть на одну меньше, чем количество групп после");

    }

}
