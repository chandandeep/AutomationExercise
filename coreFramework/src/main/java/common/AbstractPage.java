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

    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 100), this);

    }
    public WebDriver getWebDriver(){

        return webDriver;
    }


    public T navigate(final String baseUrl){
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().get(baseUrl + getUrl());
        getWebDriver().manage().window().maximize();
        return (T) this;
    }




}
