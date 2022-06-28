package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_StepDefinitions {

    @Given("user is on Meetsky login page")
    public void user_is_on_meetsky_login_page() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }
    @When("user type his valid username")
    public void user_type_his_valid_username() {
        String usernameValid = "Employee22";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("user"));
        usernameInput.sendKeys(usernameValid);
    }
    @When("user type his valid password")
    public void user_type_his_valid_password() {
        String passwordValid = "Employee123";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("password"));
        usernameInput.sendKeys(passwordValid);
    }
    @When("user click Log in button")
    public void user_click_log_in_button() {
        WebElement loginButton = Driver.getDriver().findElement(By.id("submit-form"));
        loginButton.click();
    }
    @Then("user should see Files-Meetsky-QA header")
    public void userShouldSeeFilesMeetskyQAHeader() {
        String expectedResult = "Files - Meetsky - QA";
        String actualResult = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @When("user type invalid username")
    public void user_type_invalid_username() {
        String usernameInvalid = "asd";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("user"));
        usernameInput.sendKeys(usernameInvalid);
    }
    @When("user type invalid password")
    public void user_type_invalid_password() {
        String passwordInvalid = "12345";
        WebElement passwordInput = Driver.getDriver().findElement(By.id("password"));
        passwordInput.sendKeys(passwordInvalid);
    }
    @Then("user should see {string} error")
    public void user_should_see_error(String string) {
        WebElement errorMessage1 = Driver.getDriver()
                .findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]"));
        errorMessage1.isDisplayed();
    }






}
