package pages;

import org.openqa.selenium.WebDriver;

public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage(){
        driver.get("http://addressbook.u0541324.cp.regruhosting.ru/");
        return new LoginPage(driver);
    }

    public GroupsPage openGroupsPage(){
        clickByElement(GROUPS_UPPER_MENU_LINK);
        return new GroupsPage(driver);
    }

    public AddContactPage openAddContactPage(){
        clickByElement(ADD_CONTACT_UPPER_MENU_LINK);
        return new AddContactPage(driver);
    }

    public MainPage openMainPage(){
        clickByElement(HOME_PAGE_UPPER_MENU_LINK);
        return new MainPage(driver);
    }
}
