package com.mtsky.stepDefinitions;

import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.mtsky.pages.MeetSkyLoginPage;
import com.mtsky.pages.MeetSkyResetPage;
import com.mtsky.utilities.BrowserUtils;
import com.mtsky.utilities.ConfigurationReader;
import com.mtsky.utilities.Driver;
import com.mtsky.utilities.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginFeatureStepDefs {

    MeetSkyLoginPage meetSkyLoginPage = new MeetSkyLoginPage();
    MeetSkyResetPage meetSkyResetPage = new MeetSkyResetPage();


    @Given("user is on the login page of MeetSky application.")
    public void userIsOnTheLoginPageOfMeetSkyApplication() {
        Driver.getDriver().get(ConfigurationReader.getProperty("MeetSkyLoginPage"));
    }

    @When("user enters below {string} and {string}")
    public void userEntersBelowAnd(String arg0, String arg1) {
        meetSkyLoginPage.usernameInput.sendKeys(arg0);
        meetSkyLoginPage.passwordInput.sendKeys(arg1);

    }

    @And("user clicks Log in button.")
    public void userClicksButton() {
        meetSkyLoginPage.loginButton.click();
    }

    @Then("user should see the dashboard page.")
    public void userShouldSeeTheDashboardPage() {

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Files - Meetsky - QA"));

    }

    @Then("user should see Please fill out this field message")
    public void userShouldSeeMessage() {

        Assert.assertTrue(meetSkyLoginPage.passwordInput.getAttribute("validationMessage").equals("Please fill out this field.")
                ||meetSkyLoginPage.usernameInput.getAttribute("validationMessage").equals("Please fill out this field."));

    }

    @Then("user should see password in form of dots.")
    public void userShouldSeePasswordInFormOfDots() {
        Assert.assertTrue(meetSkyLoginPage.passwordInput.getAttribute("type").equals("password"));
    }

    @When("user clicks the eye button")
    public void userClicksTheEyeButton() {
        meetSkyLoginPage.eyeButton.click();
    }

    @Then("user should see password explicitly.")
    public void userShouldSeePasswordExplicitly() {
        Assert.assertTrue(meetSkyLoginPage.passwordInput.getAttribute("type").equals("text"));
    }

    @When("user clicks Forgot password? link.")
    public void userClicksLink() {
        meetSkyLoginPage.ForgotPassword.click();
    }

    @Then("user should see the page contains Reset Password button.")
    public void userShouldSeeThePageContainsButton() {
        Assert.assertTrue(meetSkyResetPage.resetPasswordButton.isDisplayed());
    }

    @Then("user should see correct Username and Password placeholders.")
    public void userShouldSeeAndPlaceholders() {
        Assert.assertTrue(meetSkyLoginPage.usernameInput.getAttribute("placeholder").contains("Username"));
        Assert.assertTrue(meetSkyLoginPage.passwordInput.getAttribute("placeholder").contains("Password"));

    }

    @Then("user should see Wrong username or password message")
    public void userShouldSeeWrongUsernameOrPasswordMessage() {
        Assert.assertTrue(meetSkyLoginPage.wrongEmailOrUsername.isDisplayed());
    }

    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }
    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("MeetSkyLoginPage"));
    }
}
