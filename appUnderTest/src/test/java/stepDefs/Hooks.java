package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverUtils.SingletonWebDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class Hooks {

    private WebDriver driver;


    @After
    public  void logout(){
        SingletonWebDriver.getInstance().get("http://automationpractice.com/index.php?mylogout=");
    }



}
