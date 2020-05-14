package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:reports/cucumber.json",
        "junit:reports/cucumber.xml",
        "rerun:target/rerun.txt"},
        format = {"pretty", "html:target/cucumberHTMLReports"},
        monochrome = true,
        features = "src/test/resources",
        tags = {"@smoke"},
        glue = {"stepDefs"}
)

public class TestRunner{

}
