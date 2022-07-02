package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout_StepDefinitions {

    @Given("user log in with valid credentials in login page")
    public void user_log_in_with_valid_credentials_in_login_page() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");

        String validUsername = "Employee22";
        WebElement usernameBox = Driver.getDriver().findElement(By.id("user"));
        usernameBox.sendKeys(validUsername);

        String validPassword = "Employee123";
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        passwordBox.sendKeys(validPassword);

        Driver.getDriver().findElement(By.id("submit-form")).click();

    }

    @When("user is on files page")
    public void user_is_on_files_page() {
        String expectedFiles = "Files - Meetsky - QA";
        String actualFiles = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedFiles,actualFiles);
    }

    @When("user click the profile icon on the upper right of the page")
    public void user_click_the_profile_icon_on_the_upper_right_of_the_page() {
        WebElement profileIcon = Driver.getDriver().findElement(By.id("expand"));
        profileIcon.click();
    }

    @When("user click the log out button")
    public void user_click_the_log_out_button() {
        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//header//div[2]//div[4]//ul//li[4]"));
        logoutButton.click();
    }

    @Then("user should come back to the login page")
    public void user_should_come_back_to_the_login_page() {
        String expectedTitle = "Meetsky - QA";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user click go back button")
    public void user_click_go_back_button() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to home page and stay in login page")
    public void user_can_not_go_to_home_page_and_stay_in_login_page() {
        String expectedTitle = "Meetsky - QA";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
