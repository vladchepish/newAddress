package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class UpperMenuItemsTest extends TestBase {

    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected List<String> etalonItems = Arrays.asList("home", "add new", "groups", "next birthdays", "print all",
            "print phones", "map", "export", "import");

    @Test
    public void upperMenuItemsTest(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
        List<String> linksName = mainPage.getUpperMenuItemsList();
        System.out.println(linksName.size());
        for (int i = 0; i < linksName.size(); i++){
           assertEquals(linksName.get(i), etalonItems.get(i),
                   "Название пунтка меню не совпадает с ожидаемым");
        }
    }

}
