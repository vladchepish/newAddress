package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static lib.Compares.CompareFrstArgBiigerThenSecond;
import static lib.Compares.CompareTwoIntValue;
import static org.testng.Assert.assertEquals;

public class UpperMenuItemsTest extends TestBase {

    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected List<String> etalonItems = Arrays.asList("home", "add new", "groups", "next birthdays", "print all",
            "print phones", "map", "export", "import");
    private SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void beforeMethod(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
    }

    @Test
    public void upperMenuItemsTest(){
        List<String> linksName = mainPage.getUpperMenuItemsList();
        CompareTwoIntValue(linksName.size(), etalonItems.size(),
                "Количество пунктов меню должно совпадать с количеством пунктов в эталонном списке");
        for (int i = 0; i < linksName.size(); i++){
           soft.assertEquals(linksName.get(i), etalonItems.get(i),
                   "Название пунтка меню не совпадает с ожидаемым");
        }
        soft.assertAll();
    }

}
