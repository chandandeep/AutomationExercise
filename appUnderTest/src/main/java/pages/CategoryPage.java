package pages;

import common.AbstractPage;
import controls.Controllers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class CategoryPage extends AbstractPage<CategoryPage> {

    @FindBy(css = "a[title='Add to cart']")
    public WebElement addtoCartInitial;

    @FindBy(className = "product_img_link")
    public WebElement productImage;

    @FindBy(css = "a[title='Proceed to checkout']")
    public WebElement proceedToCheckOutPopUp;


    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return "?id_category=5&controller=category";
    }

    /**
     * Method to add the item to cart
     */
    public void initialAddToCart() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", productImage);
        Actions action = new Actions(webDriver);
        action.moveToElement(productImage).perform();

        Controllers.button.click(addtoCartInitial);
    }

    /**
     * Method to proceed from the pop up
     */
    public void proceedOnPopUp() {
        Controllers.button.click(proceedToCheckOutPopUp);
    }

}
