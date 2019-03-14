package runners;

import cucumber.api.CucumberOptions;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */

@CucumberOptions(plugin = {
        "json:reports/cucumber.json",
        "junit:reports/cucumber.xml"},
        format = {"pretty", "html:target/cucumberReports"},
        monochrome = true,
        features = "src/test/resources",
        tags = {"@smoke"},
        glue = {"stepDefs"}
)

public class TestRunner extends AbstractTest{

}
