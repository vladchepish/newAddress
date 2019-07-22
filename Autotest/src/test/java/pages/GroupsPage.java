package pages;

import objects.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectGroupByPosition(int index) {
        List<WebElement> elements = getElements(GROUP_CHECKBOX_INPUT);
        elements.get(index).click();
    }

    public void selectGroupById(int id) {
        getElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteGroup(Group group) {
        selectGroupById(group.getGroupId());
        pressDeleteGroupBtn();
        checkMessageBox();

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

    public List<Group> getGroupsList() {
        List<Group> groupsList = new ArrayList<Group>();
        List<WebElement> elements = getElements(GROUP_IN_LIST);
        for (WebElement e : elements) {
            Group group = new Group();
            group.setGroupName(e.getText());
            group.setGroupId(Integer.parseInt(e.findElement(By.cssSelector("input")).getAttribute("value")));
            groupsList.add(group);
        }
        return groupsList;
    }

    public Set<Group> getGroupsSet() {
        Set<Group> groupsList = new HashSet<>();
        List<WebElement> elements = getElements(GROUP_IN_LIST);
        for (WebElement e : elements) {
            Group group = new Group();
            group.setGroupName(e.getText());
            group.setGroupId(Integer.parseInt(e.findElement(By.cssSelector("input")).getAttribute("value")));
            groupsList.add(group);
        }
        return groupsList;
    }
}
