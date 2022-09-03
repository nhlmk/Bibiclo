package com.bibiclo.stepDefinitions;

import com.bibiclo.pages.BibicloLoginPage;
import com.bibiclo.pages.BibicloResetPage;
import com.bibiclo.utilities.BrowserUtils;
import com.bibiclo.utilities.ConfigurationReader;
import com.bibiclo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginFeatureStepDefs {

    BibicloLoginPage bibicloLoginPage = new BibicloLoginPage();
    BibicloResetPage bibicloResetPage = new BibicloResetPage();


    @Given("user is on the login page of MeetSky application.")
    public void userIsOnTheLoginPageOfMeetSkyApplication() {
        Driver.getDriver().get(ConfigurationReader.getProperty("MeetSkyLoginPage"));
    }

    @When("user enters below {string} and {string}")
    public void userEntersBelowAnd(String arg0, String arg1) {
        bibicloLoginPage.usernameInput.sendKeys(arg0);
        bibicloLoginPage.passwordInput.sendKeys(arg1);

    }

    @And("user clicks Log in button.")
    public void userClicksButton() {
        bibicloLoginPage.loginButton.click();
    }

    @Then("user should see the dashboard page.")
    public void userShouldSeeTheDashboardPage() {

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Files - Meetsky - QA"));

    }

    @Then("user should see Please fill out this field message")
    public void userShouldSeeMessage() {

        Assert.assertTrue(bibicloLoginPage.passwordInput.getAttribute("validationMessage").equals("Please fill out this field.")
                || bibicloLoginPage.usernameInput.getAttribute("validationMessage").equals("Please fill out this field."));

    }

    @Then("user should see password in form of dots.")
    public void userShouldSeePasswordInFormOfDots() {
        Assert.assertTrue(bibicloLoginPage.passwordInput.getAttribute("type").equals("password"));
    }

    @When("user clicks the eye button")
    public void userClicksTheEyeButton() {
        bibicloLoginPage.eyeButton.click();
    }

    @Then("user should see password explicitly.")
    public void userShouldSeePasswordExplicitly() {
        Assert.assertTrue(bibicloLoginPage.passwordInput.getAttribute("type").equals("text"));
    }

    @When("user clicks Forgot password? link.")
    public void userClicksLink() {
        bibicloLoginPage.ForgotPassword.click();
    }

    @Then("user should see the page contains Reset Password button.")
    public void userShouldSeeThePageContainsButton() {
        Assert.assertTrue(bibicloResetPage.resetPasswordButton.isDisplayed());
    }

    @Then("user should see correct Username and Password placeholders.")
    public void userShouldSeeAndPlaceholders() {
        Assert.assertTrue(bibicloLoginPage.usernameInput.getAttribute("placeholder").contains("Username"));
        Assert.assertTrue(bibicloLoginPage.passwordInput.getAttribute("placeholder").contains("Password"));

    }

    @Then("user should see Wrong username or password message")
    public void userShouldSeeWrongUsernameOrPasswordMessage() {
        Assert.assertTrue(bibicloLoginPage.wrongEmailOrUsername.isDisplayed());
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
