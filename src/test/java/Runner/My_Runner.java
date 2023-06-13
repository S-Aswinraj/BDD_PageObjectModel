package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features/"}
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,glue = {"StepDefinition","Hooks"}
//        ,dryRun = true   //  it will run without executing the code, to check feature file is mapped to step definition
//        ,monochrome = true //used to remove any unreadable characters from the console

//        ,tags = {"@uat"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty","html:reports" }
)

public class My_Runner extends AbstractTestNGCucumberTests {
}
