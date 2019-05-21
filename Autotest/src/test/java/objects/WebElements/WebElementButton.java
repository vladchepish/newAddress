package objects.WebElements;

import org.openqa.selenium.WebElement;

public class WebElementButton {

    private WebElement element;

    public WebElementButton(WebElement element){
        this.element = element;
    }

    public void click(){
        element.click();
    }
}
