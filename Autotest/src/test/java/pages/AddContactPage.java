package pages;

import objects.Contact;
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
    private static final By ANIVERSARY_MONTH_SELECT = By.cssSelector("select[name='amonth']");
    private static final By ANIVERSARY_YEAR_INPUT = By.cssSelector("input[name='ayear']");
    private static final By GROUP_SELECT = By.cssSelector("select[name='new_group']");
    private static final By ADDRESS_SECOND_TEXTAREA = By.cssSelector("textarea[name='address2']");
    private static final By HOME_SECOND_PHONE = By.cssSelector("input[name='phone2']");
    private static final By NOTES_TEXTAREA = By.cssSelector("textarea[name='notes']");
    private static final By FIRST_ENTER_BUTTON = By.xpath("//input[@name='submit'][1]");
    private static final By FIRST_UPDATE_BYTTON = By.xpath("//input[@value='Update'][1]");
    private static final By SECOND_ENTER_BUTTON = By.xpath("//input[@name='submit'][2]");

    public AddContactPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIRST_NAME_INPUT));
    }

    private AddContactPage setFirstName(String value){
        findAndFeelField(FIRST_NAME_INPUT, value);
        return this;
    }

    private AddContactPage setMiddleName(String value){
        findAndFeelField(MIDDLE_NAME_INPUT, value);
        return this;
    }

    private AddContactPage setLastName(String value){
        findAndFeelField(LAST_NAME_INPUT, value);
        return this;
    }

    private AddContactPage setNickName(String value){
        findAndFeelField(NICKNAME_INPUT, value);
        return this;
    }

    private AddContactPage setAddress(String value){
        findAndFeelField(ADDRESS_TEXTAREA, value);
        return this;
    }

    private AddContactPage setHomePhone(String value){
        findAndFeelField(HOME_PHONE_INPUT, value);
        return this;
    }

    private AddContactPage setMobilePhone(String value){
        findAndFeelField(MOBILE_PHONE_INPUT, value);
        return this;
    }

    public AddContactPage fillContactCreationField(Contact contact){
        setFirstName(contact.getFirstName());
        setMiddleName(contact.getMiddleName());
        setLastName(contact.getLastName());
        setNickName(contact.getNickName());
        setAddress(contact.getAddress());
        setHomePhone(contact.getHomePhone());
        setMobilePhone(contact.getMobilePhone());
        return this;
    }

    public AddContactPage pressEnterBtn(){
        clickByElement(FIRST_ENTER_BUTTON);
        return this;
    }

    public AddContactPage pressUpdateBtn() {
        clickByElement(FIRST_UPDATE_BYTTON);
        return this;
    }
}
