package APIRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/featureFiles"}, //# feature fle folder
        glue = {"step.definitions"}, //glue definition on this folder
        monochrome = true,
        dryRun = false,
        plugin = {
                "json:build/cucumber-reports/cucumber.json",
                "rerun:build/cucumber-reports/rerun.txt"
        })
public class TestAPIRunner {
}
