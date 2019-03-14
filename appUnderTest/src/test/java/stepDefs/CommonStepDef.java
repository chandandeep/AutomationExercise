package stepDefs;

import common.ConfigFileReader;
import driverUtils.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class CommonStepDef {

    ConfigFileReader configFileReader = new ConfigFileReader();

    protected WebDriver getWebDriver(){
        String browserName = System.getProperty("browser");
        if(browserName==null) {
            SingletonWebDriver.setBrowserName(configFileReader.getBrowserName().toString());
        }
        else {
            SingletonWebDriver.setBrowserName(browserName);
        }
        return SingletonWebDriver.getInstance();
    }

    public void navigateToUrl(){
        new LoginPage(getWebDriver()).navigate(configFileReader.getAppurl());
    }


}
