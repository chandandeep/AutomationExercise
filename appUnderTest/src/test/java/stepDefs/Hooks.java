package stepDefs;

import common.ConfigFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverUtils.SingletonWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.logging.Logger;

import static stepDefs.CommonStepDef.isSauce;


/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class Hooks {

    private WebDriver driver;
    public static String scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario.getName();
    }


    @After(order = 3)
    public  void logout(){
        SingletonWebDriver.getInstance().get("http://automationpractice.com/index.php?mylogout=");
    }


    @After(order = 2)
    public static void tearDown(Scenario scenario) {
        if(isSauce) {
            if (scenario.getStatus().toString() == "PASSED") {
                ((JavascriptExecutor) SingletonWebDriver.getInstance()).executeScript("sauce:job-result=" + "passed");
                System.out.println("Print Passed");
            } else {
                ((JavascriptExecutor) SingletonWebDriver.getInstance()).executeScript("sauce:job-result=" + "failed");
            }
        }
        if (SingletonWebDriver.isInitialized()) {
            SingletonWebDriver.getInstance().quit();
        }

    }
}
