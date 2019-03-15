package runners;

import com.cucumber.listener.Reporter;
import common.ConfigFileReader;
import cucumber.api.junit.Cucumber;
import driverUtils.SingletonWebDriver;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */

@RunWith(Cucumber.class)
public abstract class AbstractTest {


    @AfterClass
    public static void tearDown() {
        if (SingletonWebDriver.isInitialized()) {
            SingletonWebDriver.getInstance().quit();
        }

    }

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(new ConfigFileReader().getExtentReportConfigPath()));
    }
}
