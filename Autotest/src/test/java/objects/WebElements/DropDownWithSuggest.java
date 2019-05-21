package objects.WebElements;

public class DropDownWithSuggest extends WebElementLocator {

    public DropDownWithSuggest (WebElementLocator lctr){
        super(lctr);
        this.id = lctr.id;
    }

}
