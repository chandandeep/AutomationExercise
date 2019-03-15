package common;

import driverUtils.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
public class ConfigFileReader {

    private Properties properties = new Properties();
    public static final String RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\main\\resources";

    /**
     * Constructor to locate and load the property file
     */
    public ConfigFileReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(RESOURCES_PATH + "\\configuration.properties"));
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + RESOURCES_PATH + "\\configuration.properties");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ignore) {
            }
        }

    }

    /**
     * Method to get the browser name from property file
     * @return the Driver type
     */
    public DriverType getBrowserName() {
        String browser = properties.getProperty("browser");
        if (browser.equals("chrome")) {
            return DriverType.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else if (browser.equalsIgnoreCase("IE")) {
            return DriverType.IE;
        }
        else {
            return null;
        }
    }

    /**
     * Method to get the appurl from the property file
     * @return: String type of url
     */
    public String getAppurl() {
        return properties.getProperty("url");

    }

    /**
     * Generic method to get any value from property file
     * @param property
     * @return
     */
    public String getValue(String property) {
        return properties.getProperty(property);
    }

    /**
     * Method to return the path of extent report
     * @return: String value of path
     */
    public String getExtentReportConfigPath() {
        return RESOURCES_PATH + "\\extent-report-config.xml";

    }
}
