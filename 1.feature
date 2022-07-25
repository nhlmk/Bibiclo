@MTSK-458
Feature: Default

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log out.
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#User can log in successfully.
	@MTSK-455
	Scenario Outline: Verify that user logged in
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    And user clicks Log in button.
		    Then user should see the dashboard page.
		
		    Examples:
		      | username   | password    |
		      | Employee21 | Employee123 |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log out.
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#User can log out and ends up in login page
	@MTSK-456
	Scenario: Verify that user can log out and ends up in login page
		Given user is on the dashboard page.
		    When user clicks the profile button as shown with letter E
		    And user clicks the Log out button from the dropdown menu
		    Then user should see the login page.	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log out.
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#{color:#172b4d}User can not go to home page again by clicking step back button after successfully logged out.{color}
	@MTSK-457
	Scenario: Verify that user can not go to home page again by clicking step back button after successfully logged out.
		Given user is on the dashboard page.
		    When user clicks the profile button as shown with letter E
		    And user clicks the Log out button from the dropdown menu
		    And from the login page user clicks the step back button
		    Then user should not see the dashboard page again.