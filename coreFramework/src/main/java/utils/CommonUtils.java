package utils;

import driverUtils.SingletonWebDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */

public class CommonUtils {

    /**
     * Fluent wait to wait fro the element on basis of polling
     * @param element
     */
    public static void waitTillElementDisplayed(final WebElement element) {
        SuiteLogger.getGlobal().info("waiting for the element" + element);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(SingletonWebDriver.getInstance());
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
