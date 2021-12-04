package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.LogInPage;
import util.TestConfig;

import java.io.IOException;

public class PIM_EmployeeList extends TestConfig {
    @Before
    public void testSetUp() throws IOException {
        setUp();
        browser.get("https://opensource-demo.orangehrmlive.com/");

        LogInPage logIn = new LogInPage();
        logIn.userName.sendKeys("Admin");
        logIn.passWord.sendKeys("admin123");
        logIn.loginButton.click();

    }

    @Given("User can see Employee Information block")
    public void user_can_see_employee_information_block() throws IOException {
        elementType("ID","pimTab").click();
        elementType("ID","empListPage").click();

    }
    @When("User enters employee names {string}")
    public void user_enters_employee_names(String empName) {
        elementType("XPATH","empNameInput").click();
        elementType("XPATH","empNameInput").sendKeys(empName);

    }
    @When("User click on search button")
    public void user_click_on_search_button() {
        elementType("ID","searchButton").click();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    @Then("System should populate given name")
    public void system_should_populate_given_name() {

    }
    @Then("User should all the details related employee such as {string} and {string}")
    public void user_should_all_the_details_related_employee_such_as_and(String string, String string2) {
        cleanUp();

    }

}
