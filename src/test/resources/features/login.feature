Feature: MeetSky login feature
  User story: As a user, I should be able to login with correct credentials.
  And home page should be displayed.
  Valid Username: Employee21
  Valid Password: Employee123

  Scenario Outline: User enters valid credentials contains at least 2, at most 15 characters.
    Given user is on the login page of MeetSky application.
    When user enters below "<username>" and "<password>"
    And user clicks "Log in" button.
    Then user should see the home page.
    Examples:
      | username   | password    |
      | Employee21 | Employee123 |

  Scenario Outline: User enters credentials less than 2 characters
    Given user is on the login page of MeetSky application.
    When user enters below "<username>" and "<password>"
    And user clicks "Log in" button.
    Then user should see "Wrong username or password" message
    Examples:
      | username   | password    |
      | E          | Employee123 |
      | Employee21 | E           |
      | E          | E           |


  Scenario Outline: User enters credentials more than 15 characters
    Given user is on the login page of MeetSky application.
    When user enters below "<username>" and "<password>"
    And user clicks "Log in" button.
    Then user should see "Wrong username or password" message
    Examples:
      | username                       | password                          |
      | Employee21Employee21Employee21 | Employee123                       |
      | Employee21                     | Employee123Employee123Employee123 |
      | Employee21Employee21Employee21 | Employee123Employee123Employee123 |


  Scenario Outline: User does not enter any credentials
    Given user is on the login page of MeetSky application.
    When user enters below "<username>" and "<password>"
    And user clicks "Log in" button.
    Then user should see "Please fill out this field" message

    Examples:
      | username   | password    |
      |            | Employee123 |
      | Employee21 |             |
      |            |             |

    Scenario Outline: User should see the password in form of dots and should see the password explicitly if needed.
      Given user is on the login page of MeetSky application.
      When user enters below "<username>" and "<password>"
      Then user should see password in form of dots.
      When user clicks the 'eye' button
      Then user should see password explicitly.
      Examples:
        | username   | password    |
        | Employee21 | Employee123 |

      Scenario: User should see "Forgot password?" link on the login page and can see "Reset Password" button on the next page after clicking on forget password link.
        Given user is on the login page of MeetSky application.
        When user clicks "Forgot password?" link.
        Then user should see the page contains "Reset Password" button.

      Scenario: User should see valid placeholders for Username and Password fields.
          Given user is on the login page of MeetSky application.
          Then user should see "Username" and "Password" placeholders.







