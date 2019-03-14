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


    @When("^User proceed to checkout on Summary page$")
    public void user_proceed_to_checkout_on_Summary_page() {
        orderPage.proceedOnSummary();
    }

    @When("^User proceed to checkout on Address page$")
    public void user_proceed_to_checkout_on_Address_page() {
        orderPage.proceedOnAddress();
    }

    @When("^User proceed to checkout after agreeing the terms on Shipping page$")
    public void user_proceed_to_checkout_after_agreeing_the_terms_on_Shipping_page() {
        orderPage.checkAgreeCheckBox();
        orderPage.proceedOnShipping();
    }

    @When("^User notice the amount and select \"([^\"]*)\"$")
    public void user_notice_the_amount_as_and_select(String paymentMethod){
        orderPage.getTotalPrice();
        orderPage.selectPaymentMethod(paymentMethod);
    }

    @When("^User navigate back to orders after confirming the order on Payment page$")
    public void user_navigate_back_to_orders_after_confirming_the_order_on_Payment_page() {
        orderPage.confirmOnPayment();
        orderPage.getBoxData();
        orderPage.setBackToOrders();

    }

}
