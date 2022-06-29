package net.meetsky.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_StepDefinitions {

    @Given("user goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }
    @When("user is on the Meetsky login page")
    public void userIsOnTheMeetskyLoginPage() {
    }

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
    @Then("user should see Wrong username or password error")
    public void user_should_see_error() {
        WebElement errorMessage1 = Driver.getDriver()
                .findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]"));
        errorMessage1.isDisplayed();
    }


    @Then("user should see the Please fill out this field message.")
    public void user_should_see_the_please_fill_out_this_field_message() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        WebElement userBox = Driver.getDriver().findElement(By.id("user"));

        String validMessage = passwordBox.getAttribute("validationMessage") ;
        Assert.assertEquals(validMessage,"Please fill in this field");

    }
    @Then("user should see the Please fill out this field message on password input box")
    public void user_should_see_the_please_fill_out_this_field_message_on_password_input_box() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        String validMessage = passwordBox.getAttribute("validationMessage") ;
        Assert.assertEquals(validMessage,"Please fill out this field.");
    }
    @Then("user should see the Please fill out this field message on username input box")
    public void user_should_see_the_please_fill_out_this_field_message_on_username_input_box() {
        WebElement userBox = Driver.getDriver().findElement(By.id("user"));

        String validMessage = userBox.getAttribute("validationMessage") ;
        Assert.assertEquals(validMessage,"Please fill out this field.");
    }

    @Then("user should see the password as form of dots")
    public void userShouldSeeThePasswordAsFormOfDots() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        String asFormOfDots = passwordBox.getAttribute("type");
        Assert.assertEquals(asFormOfDots,"password");
    }

    @And("user click the eye image to see the password")
    public void userClickTheEyeImageToSeeThePassword() {
        WebElement eyeImage = Driver.getDriver().findElement(By.xpath("//a[@class='toggle-password']"));
        eyeImage.click();
    }
    @Then("user should see the password explicitly")
    public void userShouldSeeThePasswordExplicitly() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        String asFormOfDots = passwordBox.getAttribute("type");
        Assert.assertEquals(asFormOfDots,"text");
    }

    @When("user see the Forgot Password link")
    public void userSeeTheForgotPasswordLink() {
        WebElement forgotPasswordLink = Driver.getDriver().findElement(By.id("lost-password"));
        Assert.assertTrue(forgotPasswordLink.isDisplayed());
    }
    @And("click Forgot Password link")
    public void clickForgotPasswordLink() throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("lost-password")).click();
    }
    @Then("user should see Reset password button")
    public void userShouldSeeResetPasswordButton() {
        WebElement resetPasswordButton = Driver.getDriver().findElement(By.id("reset-password-submit"));
        boolean isResetPasswordDisplayed = true;
        Assert.assertEquals(isResetPasswordDisplayed,true);
    }

    @Then("user should see valid username and password placeholders")
    public void userShouldSeeValidUsernameAndPasswordPlaceholders() {
        WebElement usernameBox = Driver.getDriver().findElement(By.id("user"));
        String usernamePlaceholder = usernameBox.getAttribute("placeholder");
        Assert.assertEquals(usernamePlaceholder,"Username or email");

        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        String passwordPlaceholder = passwordBox.getAttribute("placeholder");
        Assert.assertEquals(passwordPlaceholder,"Password");
    }
}
