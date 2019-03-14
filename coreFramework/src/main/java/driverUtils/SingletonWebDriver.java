package driverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.SuiteLogger;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class SingletonWebDriver {


    private static SingletonWebDriver singletonWebDriver = null;
    private static WebDriver WEB_DRIVER;
    private static String BROWSER_NAME;
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";



    public static WebDriver getInstance() {
        if(singletonWebDriver==null){
            singletonWebDriver = new SingletonWebDriver();
        }
        return WEB_DRIVER;
    }


    private SingletonWebDriver() {
        String absolutePath = System.getProperty("user.dir");

        if(WEB_DRIVER==null) {
            if (BROWSER_NAME.equalsIgnoreCase(CHROME)) {
                System.setProperty("webdriver.chrome.driver", absolutePath+"\\drivers\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                WEB_DRIVER = new ChromeDriver(capabilities);
            } else if (BROWSER_NAME.equalsIgnoreCase(FIREFOX)) {
                WEB_DRIVER = new FirefoxDriver();

            }
            else{
                SuiteLogger.getGlobal().warning("No Matching browser found");
            }

        }
    }

    public static void setBrowserName(String browserName){
    BROWSER_NAME = browserName;

}

    public static boolean isInitialized(){

        return WEB_DRIVER!=null;
    }
}