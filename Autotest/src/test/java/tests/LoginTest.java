package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase{

    protected LoginPage loginPage;

    @Test(description = "Тест, который логинится в приложение")
    public void loginTest(){
        loginPage = navigation.openLoginPage();
        loginPage.typeLogin("admin");
        loginPage.typePassword("secret");
        loginPage.enterSubmitBtn();
    }
}