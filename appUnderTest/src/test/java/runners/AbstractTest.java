package runners;

import common.ConfigFileReader;
import cucumber.api.Scenario;
import driverUtils.SingletonWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public abstract class AbstractTest {


/*    @AfterClass
    public static void tearDown() {
        if (SingletonWebDriver.isInitialized()) {
            SingletonWebDriver.getInstance().quit();
        }

    }


        @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(new ConfigFileReader().getExtentReportConfigPath()));
    }*/
}
