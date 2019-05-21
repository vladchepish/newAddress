package objects.WebElements;

import org.openqa.selenium.WebElement;

public class WebElementInput{

    private WebElement element;

    public WebElementInput(WebElement element){
        this.element = element;
    }

    public void typeText(String value){
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}
