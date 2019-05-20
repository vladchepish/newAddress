package pages;

import org.openqa.selenium.WebDriver;

public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage(){
        driver.get("http://addressbook.u0541324.cp.regruhosting.ru/");
        return new LoginPage(driver);
    }
}
