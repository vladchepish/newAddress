package pages;

import lib.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait loadingWait;
    protected WebDriverWait shortWait;
    protected WebDriverWait actionWait;
    protected WebDriverWait betWait;
    protected WebDriverWait defaultWait;

    protected static final By GROUPS_UPPER_MENU_LINK = By.cssSelector("div#nav a[href*='group']");
    protected static final By ADD_CONTACT_UPPER_MENU_LINK = By.cssSelector("div#nav a[href*='edit']");
    protected static final By HOME_PAGE_UPPER_MENU_LINK = By.cssSelector("div#nav a[href='./']");
    protected static final By MESSAGE_BOX = By.cssSelector("div.msgbox");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.shortWait = new WebDriverWait(driver, TimeOut.shortTimeout);
        this.defaultWait = new WebDriverWait(driver, TimeOut.defaultTimeout);
        this.actionWait = new WebDriverWait(driver, TimeOut.action);
        this.loadingWait = new WebDriverWait(driver, TimeOut.loading);
        this.betWait = new WebDriverWait(driver, TimeOut.betTimeout);
    }

    protected WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        try {
            return driver.findElements(by);
        } catch (InvalidSelectorException e) {
            return new ArrayList<WebElement>(); //empty list
        }
    }

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            //
        }
    }

    protected void findAndFeelField(By by, String text){
        clickByElement(by);
        getElement(by).clear();
        getElement(by).sendKeys(text);
    }

    protected void findAndChoseOptionFromSelect(By by, String value){
        clickByElement(by);
        getElement(By.xpath("//li[text()='" + value + "']")).click();
    }

    protected void findAndSelectOptionFromSelect(By by, String value){
        clickByElement(by);
        getElement(by).findElement(By.xpath(".//option[text()='" + value + "']")).click();
    }

    protected void clickByElement(By by){
        getElement(by).click();
    }

    public String getTextFromMEssageBox(){
        return getElement(MESSAGE_BOX).getText();
    }
}
