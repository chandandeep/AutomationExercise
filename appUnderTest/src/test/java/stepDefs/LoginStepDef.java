package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AccountPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class LoginStepDef extends CommonStepDef {

    public LoginPage loginPage;
    public AccountPage accountPage;

    public LoginStepDef() {
        loginPage = new LoginPage(getWebDriver());
        accountPage = new AccountPage(getWebDriver());
    }


    @Given("^User click on Sign in on index page$")
    public void click_on_Sign_in_on_index_page() {
        navigateToUrl();
        loginPage.clickOnSignIn();
    }

    @When("^Login to the application with valid credentials$")
    public void loginWithValidCredentials()  {
        loginPage.enterEmail();
        loginPage.enterPasssword();
        loginPage.clickSignInButton();

    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() {
        assertThat(getWebDriver().getCurrentUrl(), containsString(accountPage.getUrl()));
    }

}
