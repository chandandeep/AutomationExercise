package controls;

import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.SuiteLogger;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class Button extends ObjectControl {

    public Button(WebElement element) {
        super(element);
    }

    /**
     * Wrapper method on Click
     * @param element: Element passed by the page class methods
     */
   public void click(WebElement element){
       CommonUtils.waitTillElementDisplayed(element);
       element.click();
   }
    
}
