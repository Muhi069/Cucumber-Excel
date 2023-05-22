package step_Definitions;


import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    private static String title;
    SoftAssert softAssert = new SoftAssert();

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    ExcelReader reader = new ExcelReader();
    String xlxFileLoc = "src/test/resources/test_data/dataRead.xlsx";

    @When("user enters username and password from given sheetname {string} and rownumber {int}")
    public void user_enters_username_and_password_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        List<Map<String, String>> testData =
                reader.getData(xlxFileLoc, sheetName);

        String Email = testData.get(rowNumber).get("email");
        System.out.println(Email);
        String Password = testData.get(rowNumber).get("password");

        loginPage.doLogin(Email, Password);
    }

    @When("User clicks the log in button")
    public void user_clicks_the_log_in_button() {
        loginPage.clickLoginBtn();
    }

    @Then("User should see the Home Page title from given sheetname {string} and rownumber {int}")
    public void user_should_see_the_home_page_title_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String, String>> testData =
                reader.getData(xlxFileLoc, sheetName);

        String Message = testData.get(rowNumber).get("message");
        String Condition = testData.get(rowNumber).get("condition");
        if (Condition == "valid") {
            System.out.println(Message);
            softAssert.assertEquals(Message, loginPage.homePageMsg());
            softAssert.assertAll();
        }

    }

    @Then("User should see invalid credentials message from given sheetname {string} and rownumber {int}")
    public void user_should_see_invalid_credentials_message_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String, String>> testData =
                reader.getData(xlxFileLoc, sheetName);

        String Message = testData.get(rowNumber).get("message");
        String Condition = testData.get(rowNumber).get("condition");

        if (Condition == "invalid") {
            System.out.println(Message);
            softAssert.assertEquals(Message, loginPage.error1());
            softAssert.assertAll();
        }
    }

    @Then("User should see no user message from given sheetname {string} and rownumber {int}")
    public void user_should_see_no_user_message_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String, String>> testData =
                reader.getData(xlxFileLoc, sheetName);

        String Message = testData.get(rowNumber).get("message");
        String Condition = testData.get(rowNumber).get("condition");

        if (Condition == "noUser") {
            System.out.println(Message);
            softAssert.assertEquals(Message, loginPage.error2());
            softAssert.assertAll();
        }
    }
}


