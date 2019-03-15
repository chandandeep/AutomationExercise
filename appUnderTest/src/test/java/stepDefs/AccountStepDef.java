package stepDefs;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AccountPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class AccountStepDef extends CommonStepDef {

    public AccountPage accountPage;

    public AccountStepDef() {
        accountPage = new AccountPage(getWebDriver());
    }


    @When("^Navigate to Personal Information on My account page$")
    public void navigate_to_Personal_Information_on_My_account_page() {
        accountPage.clickOnPersonalInformation();
        assertThat(accountPage.getNavigationPage(), equalTo("Your personal information"));
    }

    @When("^Save the form after updating the first name$")
    public void save_the_form_after_updating_the_first_name() {
        accountPage.enterFirstName();
        accountPage.enterPasswordFields();
        accountPage.submitInformation();
    }


    @Then("^Success message \"([^\"]*)\" should be displayed$")
    public void success_message_should_be_displayed(String message) {
        assertThat(accountPage.getSuccessMessage(), equalTo(message));

    }



}
