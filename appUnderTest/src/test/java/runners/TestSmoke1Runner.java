package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Chandandeep Singh on 13-03-2019.
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "junit:reports/cucumber.xml",
        "rerun:target/rerun.txt"},
        format = {"pretty", "html:target/cucumberHTMLReports","json:target/allure-results/cucumber.json"},
        monochrome = true,
        features = "src/test/resources",
        tags = {"@Test1"},
        glue = {"stepDefs"}
)

public class TestSmoke1Runner {

}
