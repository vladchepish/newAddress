package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddContactPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.cssSelector("input[name='firstname']");
    private static final By MIDDLE_NAME_INPUT = By.cssSelector("input[name='middlename']");
    private static final By LAST_NAME_INPUT = By.cssSelector("input[name='lastname']");
    private static final By NICKNAME_INPUT = By.cssSelector("input[name='nickname']");
    private static final By PHOTO_INPUT = By.cssSelector("input[name='photo']");
    private static final By COMPANY_INPUT = By.cssSelector("input[name='company']");
    private static final By ADDRESS_TEXTAREA = By.cssSelector("textarea[name='address']");
    private static final By HOME_PHONE_INPUT = By.cssSelector("input[name='home']");
    private static final By MOBILE_PHONE_INPUT = By.cssSelector("input[name='mobile']");
    private static final By WORK_PHONE_INPUT = By.cssSelector("input[name='work']");
    private static final By FAX_PHONE_INPUT = By.cssSelector("input[name='fax']");
    private static final By FIRST_EMAIL_INPUT = By.cssSelector("input[name='email']");
    private static final By SECOND_EMAIL_INPUT = By.cssSelector("input[name='email2']");
    private static final By THIRD_EMAIL_INPUT = By.cssSelector("input[name='email3']");
    private static final By HOMEPAGE_INPUT = By.cssSelector("input[name='homepage']");
    private static final By BIRTH_DAY_SELECT = By.cssSelector("select[name='bday']");
    private static final By BIRTH_MONTH_SELECT = By.cssSelector("select[name='bmonth']");
    private static final By BIRTH_YEAR_INPUT = By.cssSelector("input[name='byear']");
    private static final By ANIVERSARY_DAY_SELECT = By.cssSelector("select[name='aday']");


    public AddContactPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIRST_NAME_INPUT));
    }
}
