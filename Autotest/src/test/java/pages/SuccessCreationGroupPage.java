package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessCreationGroupPage extends BasePage {

    private static final By RETURN_TO_GROUP_PAGE_LINK = By.cssSelector("div.msgbox a[href*='group']");

    public SuccessCreationGroupPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(RETURN_TO_GROUP_PAGE_LINK));
    }

    public GroupsPage clickOnReturnLink(){
        clickByElement(RETURN_TO_GROUP_PAGE_LINK);
        return new GroupsPage(driver);
    }
}
