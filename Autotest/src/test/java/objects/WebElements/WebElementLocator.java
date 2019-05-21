package objects.WebElements;

import org.openqa.selenium.By;

public class WebElementLocator {

    public String name;
    public int index;
    public String id;
    public By by;

    // тут Я добавил самый просто конструктор для того, чтобы объясвлять его с одним только локатором
    public WebElementLocator(By by){
        this.by = by;
    }

    public WebElementLocator(By by, int index){
        this.by = by;
        this.index = index;
    }

    public WebElementLocator(String name, By by, int index){
        this.name = name;
        this.by = by;
    }

    public WebElementLocator(WebElementLocator locator) {
        this.name = locator.name;
        this.by = locator.by;
        this.index = locator.index;
    }

    @Override
    public String toString() {
        return "WebElementLocator{" +
                "name='" + name + '\'' +
                '}';
    }
}
