package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition"},
        plugin = {
                "pretty",
                "html:build/cucumber-report/cucumber.html",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failed_scenarios.txt"
               },
        monochrome = true
        ,dryRun=false
        ,tags = "@all"
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}
