package com.mtsky.stepDefinitions;

import com.mtsky.pages.MeetSkyDashboardPage;
import com.mtsky.pages.MeetSkyLoginPage;
import com.mtsky.utilities.BrowserUtils;
import com.mtsky.utilities.ConfigurationReader;
import com.mtsky.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

public class LogoutFeatureStepDef {

    MeetSkyLoginPage meetSkyLoginPage = new MeetSkyLoginPage();
    MeetSkyDashboardPage meetSkyDashboardPage = new MeetSkyDashboardPage();

    @Given("user is on the dashboard page.")
    public void userIsOnTheDashboardPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("MeetSkyLoginPage"));
        meetSkyLoginPage.usernameInput.sendKeys("Employee21");
        meetSkyLoginPage.passwordInput.sendKeys("Employee123");
        meetSkyLoginPage.loginButton.click();
    }

    @When("user clicks the profile button as shown with letter E")
    public void userClicksTheProfileButtonAsShownWithLetterE() {
        meetSkyDashboardPage.usernameIcon.click();
    }

    @And("user clicks the Log out button from the dropdown menu")
    public void userClicksTheLogOutButtonFromTheDropdownMenu() {
        meetSkyDashboardPage.logoutSelection.click();
    }

    @Then("user should see the login page.")
    public void userShouldSeeTheLoginPage() {
        meetSkyLoginPage.loginButton.isDisplayed();
    }

    @And("from the login page user clicks the step back button")
    public void fromTheLoginPageUserClicksTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should not see the dashboard page again.")
    public void userShouldNotSeeTheDashboardPageAgain() {
        meetSkyLoginPage.loginButton.isDisplayed();
    }
}
