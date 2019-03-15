package stepDefs;

import cucumber.api.java.en.When;
import pages.OrderPage;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class OrderStepDef extends CommonStepDef{

    public OrderPage orderPage;

    public OrderStepDef(){
        orderPage = new OrderPage(getWebDriver());
    }


    @When("^User completes the purchase$")
    public void user_completes_the_purchase() {
        orderPage.proceedOnSummary();
        orderPage.proceedOnAddress();
        orderPage.checkAgreeCheckBox();
        orderPage.proceedOnShipping();

    }

    @When("^User navigate back to orders after confirming the order on Payment page$")
    public void user_navigate_back_to_orders_after_confirming_the_order_on_Payment_page(){
        orderPage.getTotalPrice();
        orderPage.selectPaymentMethod();
        orderPage.confirmOnPayment();
        orderPage.getBoxData();
        orderPage.setBackToOrders();

    }
}
