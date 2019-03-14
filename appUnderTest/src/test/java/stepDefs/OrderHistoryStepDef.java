package stepDefs;

import cucumber.api.java.en.Then;
import pages.OrderHistoryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class OrderHistoryStepDef extends CommonStepDef {

    public OrderHistoryPage orderHistoryPage;
    public OrderHistoryStepDef(){
        orderHistoryPage = new OrderHistoryPage(getWebDriver());

    }

    @Then("^Verify that Order is displayed in order history page$")
    public void verify_that_Order_is_displayed_in_order_history_page() {
        assertThat(orderHistoryPage.validateOrderHistory(), equalTo(true));
    }


}
