package pages;

import common.AbstractPage;
import common.ConfigFileReader;
import controls.Controllers;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class AccountPage extends AbstractPage<AccountPage> {


    @FindBy(css = "a[title='Information']")
    public WebElement personalInformationTab;

    @FindBy(css = "span[class='navigation_page']")
    public WebElement navigationPage;

    @FindBy(id = "firstname")
    public WebElement firstNameField;

    @FindBy(id = "old_passwd")
    public WebElement oldPasswordField;

    @FindBy(id = "passwd")
    public WebElement newPasswordField;

    @FindBy(id = "confirmation")
    public WebElement confirmPasswordField;

    @FindBy(css = "button[name='submitIdentity']")
    public WebElement saveInformationButtton;

    @FindBy(css = "p[class*='alert-success']")
    public WebElement successInfoSavedMessage;

    @FindBy(id = "block_top_menu")
    public WebElement topNavigationBar;


    public static String firstName = null;

    ConfigFileReader configFileReader = new ConfigFileReader();

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public String getUrl() {
        return "?controller=my-account";
    }


    public void clickOnPersonalInformation() {
        Controllers.button.click(personalInformationTab);

    }

    public String getNavigationPage() {
        return navigationPage.getText();
    }


    public String enterFirstName() {
        firstName = RandomStringUtils.random(6, true, false);
        Controllers.textField.sendKeys(firstNameField, firstName);
        return firstName;
    }


    public void enterPasswordFields() {
        Controllers.textField.sendKeys(oldPasswordField, configFileReader.getValue("password"));
        Controllers.textField.sendKeys(newPasswordField,configFileReader.getValue("password"));
        Controllers.textField.sendKeys(confirmPasswordField,configFileReader.getValue("password"));
    }

    public void submitInformation() {
        Controllers.button.click(saveInformationButtton);
    }

    public String getSuccessMessage() {
        return successInfoSavedMessage.getText();

    }


    public <T extends AbstractPage<T>> T clickTabOnNavigation(String category) {

        List<WebElement> webElementList = topNavigationBar.findElements(By.tagName("li"));

        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().equalsIgnoreCase(category)) {
                webElementList.get(i).click();
            }
        }
        return (T) this;
    }


}
