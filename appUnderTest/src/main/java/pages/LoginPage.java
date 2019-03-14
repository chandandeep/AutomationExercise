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


    public LoginPage clickOnSignIn(){
        Controllers.button.click(SignIn);
        return this;
    }

    public LoginPage enterEmail(){
        Controllers.textField.sendKeys(emailField, configFileReader.getValue("username"));
        return this;
    }

    public LoginPage enterPasssword() {
        Controllers.textField.sendKeys(passwordField, configFileReader.getValue("password"));
        return this;
    }

    public <T extends AbstractPage<T>> T clickSignInButton(){
        Controllers.button.click(signInButton);
        return (T) this;
    }
}
