package common;

import driverUtils.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class ConfigFileReader {

    private Properties properties = new Properties();
    public static final String configPath = "\\src\\main\\resources\\configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+configPath));
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + System.getProperty("user.dir")+configPath);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ignore) {
            }
        }

    }


    public DriverType getBrowserName(){
        String browser =  properties.getProperty("browser");
        if(browser.equals("chrome")){
            return DriverType.CHROME;
        }
        else if(browser.equalsIgnoreCase("firefox")){
            return DriverType.FIREFOX;
        }
        return  null;
    }

    public String getAppurl(){
        return  properties.getProperty("url");

    }

    public String getValue(String property){
        return properties.getProperty(property);
    }
}
