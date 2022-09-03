package com.bibiclo.stepDefinitions;

import com.bibiclo.pages.BibicloDashboardPage;
import com.bibiclo.pages.BibicloLoginPage;
import com.bibiclo.utilities.ConfigurationReader;
import com.bibiclo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutFeatureStepDef {

    BibicloLoginPage bibicloLoginPage = new BibicloLoginPage();
    BibicloDashboardPage bibicloDashboardPage = new BibicloDashboardPage();

    @Given("user is on the dashboard page.")
    public void userIsOnTheDashboardPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("MeetSkyLoginPage"));
        bibicloLoginPage.usernameInput.sendKeys("Employee21");
        bibicloLoginPage.passwordInput.sendKeys("Employee123");
        bibicloLoginPage.loginButton.click();

    }

    @When("user clicks the profile button as shown with letter E")
    public void userClicksTheProfileButtonAsShownWithLetterE() {
        bibicloDashboardPage.usernameIcon.click();
    }

    @And("user clicks the Log out button from the dropdown menu")
    public void userClicksTheLogOutButtonFromTheDropdownMenu() {
        bibicloDashboardPage.logoutSelection.click();
    }

    @Then("user should see the login page.")
    public void userShouldSeeTheLoginPage() {
        bibicloLoginPage.loginButton.isDisplayed();
    }

    @And("from the login page user clicks the step back button")
    public void fromTheLoginPageUserClicksTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should not see the dashboard page again.")
    public void userShouldNotSeeTheDashboardPageAgain() {
        bibicloLoginPage.loginButton.isDisplayed();
    }
}
