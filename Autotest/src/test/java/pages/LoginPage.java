package pages;

import objects.WebElements.WebElementButton;
import objects.WebElements.WebElementInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    protected WebElementInput loginInput =
            new WebElementInput(getElement(By.cssSelector("input[name='user']")));
    protected WebElementInput passwordInput =
            new WebElementInput(getElement(By.cssSelector("input[name='pass']")));
    protected WebElementButton submitBtn =
            new WebElementButton(getElement(By.cssSelector("input[value='Login']")));

    public LoginPage(WebDriver driver) {
        super(driver);
        //shortWait.until(ExpectedConditions.visibilityOfElementLocated(loginInput));
    }

    public LoginPage typeLogin(String value){
        loginInput.typeText(value);
        return this;
    }

    public LoginPage typePassword(String value){
        passwordInput.typeText(value);
        return this;
    }

    public LoginPage enterSubmitBtn(){
        submitBtn.click();
        return this;
    }
}
