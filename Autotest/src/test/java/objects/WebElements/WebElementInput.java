package objects.WebElements;

public class WebElementInput extends WebElementLocator{

    public WebElementInput(WebElementLocator locator) {
        super(locator);
        this.id = locator.id;
    }

    public WebElementInput typeText(String value){

        return this;
    }
}
