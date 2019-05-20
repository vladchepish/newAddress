package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.Navigation;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Navigation navigation;

    @BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        BasePage basePage = new BasePage(driver);
        navigation = new Navigation(driver);
    }

    @AfterClass
    public void afterMEthod(){
        driver.quit();
    }

}
