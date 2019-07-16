package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Navigation;

public class TestBase {

    protected BasePage basePage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Navigation navigation;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
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