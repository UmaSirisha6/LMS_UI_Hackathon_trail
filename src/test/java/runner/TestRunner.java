package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;

//@Test
@CucumberOptions(
		features = "src/test/java/features/AssignmentPage.feature", 
		glue = "stepDefinitions", 
		//monochrome = true, dryRun = true,
		plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-html-reports/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests
 {

}
//		plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt" },	
