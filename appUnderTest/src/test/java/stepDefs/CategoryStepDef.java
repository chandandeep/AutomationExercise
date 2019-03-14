package stepDefs;

import cucumber.api.java.en.When;
import pages.CategoryPage;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class CategoryStepDef extends CommonStepDef {

    public CategoryPage categoryPage;

    public CategoryStepDef() {
        categoryPage = new CategoryPage(getWebDriver());

    }

    @When("^User adds the first item into the cart$")
    public void user_adds_the_first_item_into_the_cart() {
        categoryPage.initialAddToCart();
    }

    @When("^User proceed to checkout on pop up$")
    public void user_proceed_to_checkout_on_pop_up() {
        categoryPage.proceedOnPopUp();
    }

}
