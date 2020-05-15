package runners;

import cucumber.api.CucumberOptions;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */

@CucumberOptions(plugin = {
        "json:reports/cucumber.json",
        "junit:reports/cucumber.xml"},
        format = {"pretty", "html:target/cucumberHTMLReports"},
        monochrome = true,
        features = "@target/rerun.txt",
        glue = {"stepDefs"}
)

public class TestRunnerRetry extends AbstractTest{

}
