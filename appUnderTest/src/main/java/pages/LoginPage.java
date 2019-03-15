package pages;

import common.AbstractPage;
import common.ConfigFileReader;
import controls.Controllers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class LoginPage extends AbstractPage<LoginPage>

{

    @FindBy(css="a[class='login']")
    public WebElement SignIn;

    @FindBy(id="email")
    public WebElement emailField;

    @FindBy(id="passwd")
    public WebElement passwordField;

    @FindBy(id="SubmitLogin")
    public WebElement signInButton;

    ConfigFileReader configFileReader = new ConfigFileReader();
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getUrl() {
        return "/index.php";
    }

    /**
     * Method to click on sign in button
     */
    public void clickOnSignIn(){
        Controllers.button.click(SignIn);
    }

    /**
     *Method to enter the mail in login page
     */
    public void enterEmail(){
        Controllers.textField.sendKeys(emailField, configFileReader.getValue("username"));
    }

    /**
     * Method to enter the password in the Login page
     */
    public void enterPasssword() {
        Controllers.textField.sendKeys(passwordField, configFileReader.getValue("password"));
    }

    /**
     * Method to click on sign in page
     * @param <T> - generic type to make sure that page on which user is navigating should be extending the Abstract page
     * @return - The page on which the user is navigating
     */
    public <T extends AbstractPage<T>> T clickSignInButton(){
        Controllers.button.click(signInButton);
        return (T) this;
    }
}
