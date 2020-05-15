package driverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.SuiteLogger;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 * This is the singleton class to create a single instance of driver which can be shared by the other objects
 */
public  class SingletonWebDriver {


    private static SingletonWebDriver singletonWebDriver = null;
    private static WebDriver WEB_DRIVER;
    private static boolean isRemote = false;
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
        if(isRemote == true){
            String sauceUserName = System.getenv("SAUCE_USERNAME");
            String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("username", sauceUserName);
            capabilities.setCapability("accessKey", sauceAccessKey);
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("version", "59.0");
            try {
                WEB_DRIVER = new RemoteWebDriver(new URL("https://chan_asr:fe06e9fe-deb7-4f81-82b3-acc85f0c215a@ondemand.saucelabs.com:443/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        if (WEB_DRIVER == null) {
            if (BROWSER_NAME.equalsIgnoreCase(CHROME)) {
                WebDriverManager.chromedriver().setup();
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

    public static void setRemote(boolean flag){
        isRemote = flag;
    }

    /**
     * Method to validatte if the initialization is done or is null
     * @return - boolean value True or False
     */
    public static boolean isInitialized() {
        return WEB_DRIVER != null;
    }

}