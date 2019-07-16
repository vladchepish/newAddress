package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import static lib.Compares.CompareTwoIntValue;

public class ContactDeletionTest extends TestBase {

    protected LoginPage loginPage;
    protected MainPage mainPage;

    @BeforeMethod
    public void loginMethod() {
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
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
