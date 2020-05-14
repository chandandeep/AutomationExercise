package common;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public abstract class AbstractPage<T extends AbstractPage<T>> {

    public abstract String getUrl();

    public final WebDriver webDriver;

    /**
     * Constructor to initialize the elements of the base classes
     * @param webDriver - Parameter of type Webdriver
     */
    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), this);

    }

    /**
     * Method to return the webdriver
     * @return - Webdriver
     */
    public WebDriver getWebDriver(){
        return webDriver;
    }

    /**
     * Method to navigate to the required url and delete the cookies of the browser
     * @param baseUrl - base url defined in configurations
     * @return - Type of the page extending Abstract page
     */
    public T navigate(final String baseUrl){
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().get(baseUrl + getUrl());
        getWebDriver().manage().window().maximize();
        return (T) this;
    }




}
