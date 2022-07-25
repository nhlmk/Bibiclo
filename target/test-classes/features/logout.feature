@MTSK-458
@LogoutFeature
Feature: MeetSky logout feature.
  User Story : As a user, I should be able to logout.
  And login page successfully displayed.
  Valid Username: Employee21
  Valid Password: Employee123
  @MTSK-455
  @TestForLogin
  Scenario Outline: User enters valid credentials contains at least 2, at most 15 characters.
    Given user is on the login page of MeetSky application.
    When user enters below "<username>" and "<password>"
    And user clicks Log in button.
    Then user should see the dashboard page.

    Examples:
      | username   | password    |
      | Employee21 | Employee123 |
  @MTSK-456
  @TestForSuccessfulLogout
  Scenario: User can log out and ends up in login page.
    Given user is on the dashboard page.
    When user clicks the profile button as shown with letter E
    And user clicks the Log out button from the dropdown menu
    Then user should see the login page.
  @MTSK-457
  @TestForStepBack
  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given user is on the dashboard page.
    When user clicks the profile button as shown with letter E
    And user clicks the Log out button from the dropdown menu
    And from the login page user clicks the step back button
    Then user should not see the dashboard page again.