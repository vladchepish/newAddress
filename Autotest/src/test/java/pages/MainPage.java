package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    private static final By LOGOUT_BTN = By.cssSelector("a[onclick=\"document.logout.submit();\"]");
    private static final By UPPER_MENU_LIST_ITEM_LINK = By.cssSelector("div#nav a");
    private static final By SEARCH_STRING_INPUT = By.cssSelector("input[name='searchstring']");
    private static final By CONTACT_LINE_IN_TABLE = By.cssSelector("tr[name='entry']");

    public MainPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_STRING_INPUT));
    }

    public List<String> getUpperMenuItemsList() {
        List<WebElement> linksList = getElements(UPPER_MENU_LIST_ITEM_LINK);
        List<String> linksNamesList = new ArrayList<String>();
        for (WebElement li : linksList){
            linksNamesList.add(li.getText());
        }
        return linksNamesList;
    }

    public int countContacts(){
        return getElements(CONTACT_LINE_IN_TABLE).size();
    }
}
