package pages;

import objects.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddGroupPage extends BasePage {

    private static final By GROUP_NAME_INPUT = By.cssSelector("input[name='group_name']");
    private static final By GROUP_HEADER_TEXTAREA = By.cssSelector("textarea[name='group_header']");
    private static final By GROUP_FOOTER_TEXTAREA = By.cssSelector("textarea[name='group_footer']");
    private static final By SUBMIN_BTN = By.cssSelector("input[name='submit']");

    public AddGroupPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(GROUP_NAME_INPUT));
    }

    public AddGroupPage setGroupName(String value){
        findAndFeelField(GROUP_NAME_INPUT, value);
        return this;
    }

    public AddGroupPage setGroupHeader(String value){
        findAndFeelField(GROUP_HEADER_TEXTAREA, value);
        return this;
    }

    public AddGroupPage setGroupFooter(String value){
        findAndFeelField(GROUP_FOOTER_TEXTAREA, value);
        return this;
    }

    public SuccessCreationGroupPage pressEnterInformationBtn(){
        clickByElement(SUBMIN_BTN);
        return new SuccessCreationGroupPage(driver);
    }

    public AddGroupPage fillGroupCreationFields(GroupDate group){
        setGroupName(group.getGroupName());
        setGroupHeader(group.getGroupHeader());
        setGroupFooter(group.getGroupFooter());
        return this;
    }
}
