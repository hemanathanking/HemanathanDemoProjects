package CucumberTestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(

		features = "src/test/java/Features",
		dryRun = !true,
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		glue = "Steps",
		plugin = {"pretty", "html:target/cucumber-reports.html"}

)

public class TestRunner extends AbstractTestNGCucumberTests {

}
