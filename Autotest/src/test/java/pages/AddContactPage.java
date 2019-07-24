package pages;

import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static Utils.DataHelper.cleanPhone;

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

    private void setHomePhone(String value) {
        findAndFeelField(HOME_PHONE_INPUT, value);
    }

    private void setMobilePhone(String value) {
        findAndFeelField(MOBILE_PHONE_INPUT, value);
    }

    private void setCompany(String value) {
        findAndFeelField(COMPANY_INPUT, value);
    }

    private void setWorkPhone(String value) {
        findAndFeelField(WORK_PHONE_INPUT, value);
    }

    private void setFax(String value) {
        findAndFeelField(FAX_PHONE_INPUT, value);
    }

    private void setFirstEmail(String value) {
        findAndFeelField(FIRST_EMAIL_INPUT, value);
    }

    private void setSecondEmail(String value) {
        findAndFeelField(SECOND_EMAIL_INPUT, value);
    }

    private void setThirdEmail(String value) {
        findAndFeelField(THIRD_EMAIL_INPUT, value);
    }

    private void setHomepage(String value) {
        findAndFeelField(HOMEPAGE_INPUT, value);
    }

    private void setSecondAddress(String value) {
        findAndFeelField(ADDRESS_SECOND_TEXTAREA, value);
    }

    private void setHomeSecondPhone(String value) {
        findAndFeelField(HOME_SECOND_PHONE, value);
    }

    private void setNotes(String value) {
        findAndFeelField(NOTES_TEXTAREA, value);
    }

    private void setGroup(String value) {
        new Select(getElement(GROUP_SELECT)).selectByVisibleText(value);
    }

    private void setPhoto(File file) {
        getElement(PHOTO_INPUT).sendKeys(file.getAbsolutePath());
    }

    public void fillContactCreationField(Contact contact, boolean isGroupPresenr) {
        fillContactCreationField(contact);
        setGroup(contact.getGroup());
    }

    public void fillContactCreationField(Contact contact) {
        setFirstName(contact.getFirstName());
        setMiddleName(contact.getMiddleName());
        setLastName(contact.getLastName());
        setNickName(contact.getNickName());
        setPhoto(contact.getPhoto());
        setCompany(contact.getCompany());
        setAddress(contact.getAddress());
        setHomePhone(contact.getHomePhone());
        setMobilePhone(contact.getMobilePhone());
        setWorkPhone(contact.getWorkPhone());
        setHomePhone(contact.getHomePhone());
        setFax(contact.getFax());
        setFirstEmail(contact.getFirstEmail());
        setSecondEmail(contact.getSecondEmail());
        setThirdEmail(contact.getThirdEmail());
        setHomepage(contact.getHomepage());
        setSecondAddress(contact.getSecondAddress());
        setHomeSecondPhone(contact.getSecondHome());
        setNotes(contact.getSecondNotes());
    }

    public AddContactPage pressEnterBtn(){
        clickByElement(FIRST_ENTER_BUTTON);
        return this;
    }

    public AddContactPage pressUpdateBtn() {
        clickByElement(FIRST_UPDATE_BYTTON);
        return this;
    }

    public Contact getContact() {
        Contact contact = new Contact();
        contact.setFirstName(getTextFromInput(FIRST_NAME_INPUT));
        contact.setMiddleName(getTextFromInput(MIDDLE_NAME_INPUT));
        contact.setLastName(getTextFromInput(LAST_NAME_INPUT));
        contact.setNickName(getTextFromInput(NICKNAME_INPUT));
        contact.setAddress(getTextFromInput(ADDRESS_TEXTAREA));
        contact.setCompany(getTextFromInput(COMPANY_INPUT));
        contact.setWorkPhone(getTextFromInput(WORK_PHONE_INPUT));
        contact.setHomePhone(getTextFromInput(HOME_PHONE_INPUT));
        contact.setMobilePhone(getTextFromInput(MOBILE_PHONE_INPUT));
        contact.setFirstEmail(getTextFromInput(FIRST_EMAIL_INPUT));
        contact.setSecondEmail(getTextFromInput(SECOND_EMAIL_INPUT));
        contact.setThirdEmail(getTextFromInput(THIRD_EMAIL_INPUT));
        contact.setSecondHome(getTextFromInput(HOME_SECOND_PHONE));
        contact.setAllPhones(buildAllPhones(cleanPhone(contact.getHomePhone()),
                cleanPhone(contact.getMobilePhone()),
                cleanPhone(contact.getWorkPhone()),
                cleanPhone(contact.getSecondHome())));
        contact.setAllEmails(buildAllEmails(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail()));
        return contact;
    }

    private String buildAllEmails(String firstEmail, String secondEmail, String thirdEmail) {
        String allEmails = "";
        List<String> emails = Arrays.asList(firstEmail, secondEmail, thirdEmail);
        for (String e : emails) {
            if (e != null || !e.equals("")) {
                allEmails = allEmails + e + " ";
            }
        }
        return allEmails.trim();
    }

    private String buildAllPhones(String homePhone, String mobilePhone, String workPhone, String secondHomePhone) {
        String allPhones = "";
        List<String> phones = Arrays.asList(homePhone, mobilePhone, workPhone, secondHomePhone);
        for (String p : phones) {
            if (p != null || p.equals("")) {
                allPhones = allPhones + p + " ";
            }
        }
        return allPhones.trim();
    }
}
