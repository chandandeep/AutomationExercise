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

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return "?controller=order&step=0";
    }

    public void proceedOnSummary() {
        Controllers.button.click(proceedToCheckOutSummary);
    }

    public void proceedOnAddress() {
        Controllers.button.click(proceedToCheckOutAddress);
    }

    public void checkAgreeCheckBox() {
        agreeCheckBox.click();

    }

    public void proceedOnShipping() {
        Controllers.button.click(proceedToShipping);
    }

    public String getTotalPrice() {
        totalPriceValue = totalPrice.getText();
        return totalPriceValue;
    }

    public void selectPaymentMethod(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("bankwire")) {
            Controllers.button.click(bankWirePayment);
        } else {
            Controllers.button.click(chequePayment);
        }
    }

    public void confirmOnPayment() {
        Controllers.button.click(confirmOnPaymentButton);
    }


    public String getBoxData() {
        boxText = box.getText();
        return boxText;
    }

    public void setBackToOrders() {
        backToOrdersLink.click();
    }

}
