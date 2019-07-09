package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class ContactCreationTest extends TestBase{

    protected LoginPage loginPage;
    protected MainPage mainPage;

    @Test
    public void testContactCreation(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");

    }

}
