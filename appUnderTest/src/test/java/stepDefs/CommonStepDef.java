package stepDefs;

import common.ConfigFileReader;
import cucumber.api.Scenario;
import driverUtils.SingletonWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static stepDefs.Hooks.scenario;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class CommonStepDef {

    ConfigFileReader configFileReader = new ConfigFileReader();
      public static boolean isSauce ;
    protected WebDriver getWebDriver(){
        String browserName = System.getProperty("browser");
        if(browserName==null) {
            isSauce = Boolean.parseBoolean(configFileReader.getSauceExecution());
            SingletonWebDriver.setBrowserName(configFileReader.getBrowserName().toString());
            SingletonWebDriver.setRemote(isSauce);
        }
        else {
            SingletonWebDriver.setBrowserName(browserName);
        }
        return SingletonWebDriver.getInstance();
    }

    public void navigateToUrl(){
        if(isSauce) {
            ((JavascriptExecutor) getWebDriver()).executeScript("sauce:job-name=" + scenario);
        }
        new LoginPage(getWebDriver()).navigate(configFileReader.getAppurl());
    }


}
