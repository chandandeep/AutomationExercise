package controls;

import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.SuiteLogger;

import java.util.logging.Logger;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class TextField extends ObjectControl {

    public TextField(WebElement element) {
        super(element);
    }

    /**
     * Wrapper method to clear and then enter the values
     * @param element
     * @param charSequences
     */
    public void sendKeys(WebElement element, CharSequence...charSequences ){
        CommonUtils.waitTillElementDisplayed(element);
        element.clear();
        element.sendKeys(charSequences);
    }

}
