package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupsPage extends BasePage {

    private static final By GROUPS_PAGE_HEADER = By.xpath("//h1[text()='Groups']");
    private static final By CREATE_NEW_GROUP_BUTTON_UPPER = By.xpath("//input[@name='new'][1]");
    private static final By GROUP_IN_LIST = By.cssSelector("span.group");

    public GroupsPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(GROUPS_PAGE_HEADER));
    }

    public AddGroupPage pressAddNewGroupBtn(){
        clickByElement(CREATE_NEW_GROUP_BUTTON_UPPER);
        return new AddGroupPage(driver);
    }

    public int countGroups(){
        return getElements(GROUP_IN_LIST).size();
    }
}
