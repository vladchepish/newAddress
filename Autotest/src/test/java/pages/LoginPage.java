package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    protected static final By LOGIN_INPUP = By.cssSelector("input[name='user']");
    protected static final By PASSWORD_INPUT = By.cssSelector("input[name='pass']");
    protected static final By SUBMIN_BTN = By.cssSelector("input[value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
        //shortWait.until(ExpectedConditions.visibilityOfElementLocated(loginInput));
    }

    public LoginPage typeLogin(String value){
        findAndFeelField(LOGIN_INPUP, value);
        return this;
    }

    public LoginPage typePassword(String value){
        findAndFeelField(PASSWORD_INPUT, value);
        return this;
    }

    public LoginPage enterSubmitBtn(){
        clickByElement(SUBMIN_BTN);
        return this;
    }
}
