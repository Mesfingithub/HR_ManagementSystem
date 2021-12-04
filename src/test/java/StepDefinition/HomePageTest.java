package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class HomePageTest extends TestConfig {

    @Given("user is able to open the browser with the valid url")
    public void user_is_able_to_open_the_browser_with_the_valid_url() throws IOException {
        setUp();
        browser.get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("User see homepage")
    public void user_see_homepage() {
        String homePage = browser.getTitle();
        validation(homePage, "OrangeHRM");

    }

    @When("System should verify the page title and current url")
    public void system_should_verify_the_page_title_and_current_url() {
        String homePageURL = browser.getCurrentUrl();
        validation(homePageURL,"https://opensource-demo.orangehrmlive.com/");

    }

    @Then("HomePage validation is completed")
    public void home_page_validation_is_completed() throws InterruptedException, IOException {

        cleanUp();

    }
    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {
    elementType("XPATH","userName").sendKeys(username);


    }

    @When("User enters the valid password {string}")
    public void user_enters_the_valid_password(String password) {
        elementType("XPATH","passWord").sendKeys(password);

    }

    @When("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        elementType("ID","loginButton").click();

    }

    @Then("System should authenticate user and redirect to Admin Dashboard page")
    public void system_should_authenticate_user_and_redirect_to_admin_dashboard_page() {
        String dashBoard = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        validation(dashBoard, browser.getCurrentUrl());
        cleanUp();

    }

}
