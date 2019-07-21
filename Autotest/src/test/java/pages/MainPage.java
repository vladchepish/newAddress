package pages;

import objects.Contact;
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
    private static final By CONTACT_CHECKBOX_INPUT = By.cssSelector("table#maintable input[type='checkbox']");
    private static final By DELETE_BUTTON = By.cssSelector("input[value='Delete']");
    private static final By EDIT_CONTACT_BUTTON = By.cssSelector("table#maintable a[href*='edit']");

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

    public MainPage selectFirstContact() {
        clickByElement(CONTACT_CHECKBOX_INPUT);
        return this;
    }

    public void pressDeleteBtn() {
        clickByElement(DELETE_BUTTON);
    }

    public void confirmDeletion() {
        driver.switchTo().alert().accept();
    }

    public AddContactPage pressEditFirstContactBtn() {
        clickByElement(EDIT_CONTACT_BUTTON);
        return new AddContactPage(driver);
    }

    public List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        List<WebElement> elements = getElements(CONTACT_LINE_IN_TABLE);
        for (WebElement e : elements) {
            Contact contact = new Contact();
            contact.setLastName(e.findElement(By.xpath(".//td[2]")).getText());
            contact.setFirstName(e.findElement(By.xpath(".//td[3]")).getText());
            contact.setAddress(e.findElement(By.xpath(".//td[4]")).getText());
            contact.setId(Integer.parseInt(e.findElement(By.xpath(".//td[1]//input")).getAttribute("id")));
            contacts.add(contact);
        }
        return contacts;
    }
}
