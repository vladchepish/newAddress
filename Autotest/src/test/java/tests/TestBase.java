package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.Navigation;


public class TestBase {

    protected BasePage basePage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Navigation navigation;

    @BeforeClass
    public void beforeClass() {
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

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}