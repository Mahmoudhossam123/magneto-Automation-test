package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (
      
        features = "src/main/resources/Features",
        glue = {"utility", "stepDefinition" },
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" }
)
public class TestRunner {

}
