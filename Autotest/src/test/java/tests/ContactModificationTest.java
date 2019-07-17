package tests;

import objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.CustomObjectsGenerator.generateRandomContact;

public class ContactModificationTest extends TestBase {

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddContactPage addContactPage;

    @BeforeMethod
    public void loginMethod() {
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
    }

    @Test(description = "Тест, который модицицирует первый контакт в списке")
    public void testContactModification() {
        Contact contact = generateRandomContact();
        addContactPage = mainPage.pressEditFirstContactBtn();
        addContactPage.fillContactCreationField(contact);
        addContactPage.pressUpdateBtn();
        navigation.openMainPage();

    }

}
