package pages;

import objects.WebElements.WebElementInput;
import objects.WebElements.WebElementLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    protected static final WebElementInput LOGIN_INPUT =
            new WebElementInput(new WebElementLocator(By.cssSelector("input[name='user']")));
    //protected static final By LOGIN_INPUT = By.cssSelector("input[name='user']");
    protected static final By PASSWORD_INPUT = By.cssSelector("input[name='pass']");
    protected static final By SUBMIT_BTN = By.cssSelector("input[value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
        //shortWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_INPUT));
    }

    public LoginPage typeLogin(String value){
    //    findAndFeelField(LOGIN_INPUT, value);
        LOGIN_INPUT.typeText(value);
        return this;
    }

    public LoginPage typePassword(String value){
        findAndFeelField(PASSWORD_INPUT, value);
        return this;
    }

    public LoginPage enterSubmitBtn(){
        clickByElement(SUBMIT_BTN);
        return this;
    }
}
