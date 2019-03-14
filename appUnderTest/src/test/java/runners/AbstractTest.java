package runners;

import cucumber.api.junit.Cucumber;
import driverUtils.SingletonWebDriver;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */

@RunWith(Cucumber.class)
public abstract class AbstractTest {


    @AfterClass
    public static void tearDown() {
        if (SingletonWebDriver.isInitialized()) {
            SingletonWebDriver.getInstance().close();
            SingletonWebDriver.getInstance().quit();
        }

    }

}
