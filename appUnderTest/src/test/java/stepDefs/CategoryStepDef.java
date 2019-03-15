package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.AccountPage;
import pages.CategoryPage;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class CategoryStepDef extends CommonStepDef {

    public CategoryPage categoryPage;
    public AccountPage accountPage;

    public CategoryStepDef() {
        categoryPage = new CategoryPage(getWebDriver());
        accountPage = new AccountPage(getWebDriver());

    }

    @Given("^User navigates to \"([^\"]*)\" section and start purchasing the first item$")
    public void user_navigates_to_section_and_start_purchasing_the_first_item(String category){
    accountPage.clickTabOnNavigation(category);
        categoryPage.initialAddToCart();
        categoryPage.proceedOnPopUp();
    }

}
