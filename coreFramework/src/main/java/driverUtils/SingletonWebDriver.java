package driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.SuiteLogger;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 * This is the singleton class to create a single instance of driver which can be shared by the other objects
 */
public class SingletonWebDriver {


    private static SingletonWebDriver singletonWebDriver = null;
    private static WebDriver WEB_DRIVER;
    private static String BROWSER_NAME;
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String IE = "IE";


    /**
     * getInstance method to return the webdriver reference in case the reference to this class is null.
     * @return - Webdriver reference
     */
    public static WebDriver getInstance() {
        if (singletonWebDriver == null) {
            singletonWebDriver = new SingletonWebDriver();
        }
        return WEB_DRIVER;
    }


    /**
     * Private constructor to initialize the drivers of different type
     */
    private SingletonWebDriver() {
        String absolutePath = System.getProperty("user.dir");
        if (WEB_DRIVER == null) {
            if (BROWSER_NAME.equalsIgnoreCase(CHROME)) {
                WebDriverManager.chromedriver().version("2.40").setup();
                WEB_DRIVER = new ChromeDriver();
            } else if (BROWSER_NAME.equalsIgnoreCase(FIREFOX)) {
                WebDriverManager.firefoxdriver().setup();
                WEB_DRIVER = new FirefoxDriver();
            } else if(BROWSER_NAME.equalsIgnoreCase(IE)) {
                WebDriverManager.iedriver().setup();
                WEB_DRIVER = new InternetExplorerDriver();
            }
            else{
                SuiteLogger.getGlobal().warning("No Matching browser found");
            }

        }
    }

    /**
     * This method will set the browser name depending upon the parameter passed by user
     * @param browserName - String value of browser
     */
    public static void setBrowserName(String browserName) {
        BROWSER_NAME = browserName;

    }

    /**
     * Method to validatte if the initialization is done or is null
     * @return - boolean value True or False
     */
    public static boolean isInitialized() {
        return WEB_DRIVER != null;
    }
}