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

    protected WebDriver getWebDriver(){
        String browserName = System.getProperty("browser");
        if(browserName==null) {
            SingletonWebDriver.setBrowserName(configFileReader.getBrowserName().toString());
            SingletonWebDriver.setRemote(Boolean.parseBoolean(configFileReader.getSauceExecution()));
        }
        else {
            SingletonWebDriver.setBrowserName(browserName);
        }
        return SingletonWebDriver.getInstance();
    }

    public void navigateToUrl(){
        ((JavascriptExecutor) getWebDriver()).executeScript("sauce:job-name=" + scenario);
        new LoginPage(getWebDriver()).navigate(configFileReader.getAppurl());
    }


}
