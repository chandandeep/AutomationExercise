package controls;

import org.openqa.selenium.WebElement;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 *
 */

public class Controllers {


    public static WebElement element;


    public static Button button = new Button(element);
    public static TextField textField = new TextField(element);

}
