package controls;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class ObjectControl {

    public WebElement element;

    public ObjectControl(WebElement element){
        this.element = element;
    }


}
