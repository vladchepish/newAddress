package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.Navigation;


public class TestBase {

    protected static BasePage basePage;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Navigation navigation;

    @BeforeSuite
    public static void beforeClass() {
        String browser = BrowserType.CHROME;
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
        navigation = new Navigation(driver);
    }

    @AfterMethod
    public void cleanCoockey() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterClass(){
        driver.quit();
    }

}