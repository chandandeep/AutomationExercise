package pages;

import common.AbstractPage;
import controls.Controllers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class OrderPage extends AbstractPage<OrderPage> {


    @FindBy(css = "p[class*='cart_navigation'] a[title='Proceed to checkout']")
    public WebElement proceedToCheckOutSummary;

    @FindBy(css = "button[name='processAddress']")
    public WebElement proceedToCheckOutAddress;

    @FindBy(id = "cgv")
    public WebElement agreeCheckBox;

    @FindBy(css = "button[name='processCarrier']")
    public WebElement proceedToShipping;

    @FindBy(id = "total_price")
    public WebElement totalPrice;

    @FindBy(className = "bankwire")
    public WebElement bankWirePayment;

    @FindBy(className = "cheque")
    public WebElement chequePayment;

    @FindBy(css = "p[class*='cart_navigation'] button[type='submit']")
    public WebElement confirmOnPaymentButton;

    @FindBy(css = "div[class='box']")
    public WebElement box;

    @FindBy(css = "a[title='Back to orders']")
    public WebElement backToOrdersLink;


    public static String boxText;
    public static String totalPriceValue;
    public OrderHistoryPage orderHistoryPage = new OrderHistoryPage(getWebDriver());
    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return "?controller=order&step=0";
    }

    /**
     * Method to proceed from summary on cart
     */
    public void proceedOnSummary() {
        Controllers.button.click(proceedToCheckOutSummary);
    }

    /**
     * Method to proceed from Address on cart
     */
    public void proceedOnAddress() {
        Controllers.button.click(proceedToCheckOutAddress);
    }

    /**
     * Method to select the check box
     */
    public void checkAgreeCheckBox() {
        agreeCheckBox.click();

    }

    /**
     * Method to proceed from shipping page
     */
    public void proceedOnShipping() {
        Controllers.button.click(proceedToShipping);
    }

    /**
     * Method to get the total price
     * @return - String value of price
     */
    public String getTotalPrice() {
        totalPriceValue = totalPrice.getText();
        return totalPriceValue;
    }

    /**
     * Method to select the payment method
     */
    public void selectPaymentMethod() {
            Controllers.button.click(bankWirePayment);
    }

    /**
     * Method to confirm on payment page
     */
    public void confirmOnPayment() {
        Controllers.button.click(confirmOnPaymentButton);
    }

    /**
     * Method to get the String in Box
     * @return - String value of box data
     */
    public String getBoxData() {
        boxText = box.getText();
        return boxText;
    }

    /**
     * Method to go to History orders
     */
    public OrderHistoryPage setBackToOrders() {
        backToOrdersLink.click();
        return orderHistoryPage;
    }

}
