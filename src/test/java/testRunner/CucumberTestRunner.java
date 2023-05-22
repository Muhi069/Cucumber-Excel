package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/appFeatures/Login.feature",
        glue = {"step_Definitions", "appHooks"},
        plugin = { "pretty",

                "html:test-output/cucumber-report/nopCommerce-pretty.html",
                "json:test-output/cucumber-report/nopCommerce.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        }


)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
