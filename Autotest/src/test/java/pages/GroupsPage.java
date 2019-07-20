package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GroupsPage extends BasePage {

    private static final By GROUPS_PAGE_HEADER = By.xpath("//h1[text()='Groups']");
    private static final By CREATE_GROUP_BUTTON_UPPER = By.xpath("//input[@name='new'][1]");
    private static final By GROUP_IN_LIST = By.cssSelector("span.group");
    private static final By GROUP_CHECKBOX_INPUT = By.cssSelector("input[type='checkbox']");
    private static final By DELETE_GROUP_BUTTON_UPPER = By.xpath("//input[@name='delete'][1]");
    private static final By EDIT_GROUP_BUTTON_UPPER = By.xpath("//input[@name='edit'][1]");
    private static final By FIRST_GROUP_IN_LIST = By.xpath("//span[@class='group'][1]");

    public GroupsPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(GROUPS_PAGE_HEADER));
    }

    public AddGroupPage pressAddNewGroupBtn(){
        clickByElement(CREATE_GROUP_BUTTON_UPPER);
        return new AddGroupPage(driver);
    }

    public int countGroups(){
        return getElements(GROUP_IN_LIST).size();
    }

    public GroupsPage selectFirstGroupInList() {
        clickByElement(GROUP_CHECKBOX_INPUT);
        return this;
    }

    public GroupsPage pressDeleteGroupBtn() {
        clickByElement(DELETE_GROUP_BUTTON_UPPER);
        return this;
    }

    public AddGroupPage pressEditGroupBtn(){
        clickByElement(EDIT_GROUP_BUTTON_UPPER);
        return new AddGroupPage(driver);
    }

    public GroupsPage checkMessageBox() {
        Assert.assertTrue(getTextFromMEssageBox().contains("Group has been removed"),
                "Текст в сообщении не содежрит необходимую часть");
        return this;
    }

    public String getFirstGroupName() {
        return getElement(FIRST_GROUP_IN_LIST).getText();
    }
}
