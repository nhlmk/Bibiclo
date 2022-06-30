@MTSK-388
Feature: Default

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#1-User can login with valid credentials 
	#
	#     -Credentials should contain at least 2, at most 15 characters.
	@MTSK-381
	Scenario Outline: Verify that user can log in with valid credentials
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    And user clicks Log in button.
		    Then user should see the dashboard page.
		
		    Examples:
		      | username   | password    |
		      | Employee21 | Employee123 |	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#{color:#172b4d}2-User can not login with any invalid credentials
	#     -"Wrong username or password." should be displayed for invalid credentials
	#     -"Please fill out this field" message should be displayed if the password or username is empty{color}
	@MTSK-382
	Scenario: Verify that user can not login with credentials less than 2 characters
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    And user clicks Log in button.
		    Then user should see Wrong username or password message
		
		    Examples:
		      | username   | password    |
		      | E          | Employee123 |
		      | Employee21 | E           |
		      | E          | E           |	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#2-User can not login with any invalid credentials
	#     -"Wrong username or password." should be displayed for invalid credentials
	#     -"Please fill out this field" message should be displayed if the password or username is empty
	@MTSK-383
	Scenario Outline: Verify that user can not login with credentials more than 15 characters
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    And user clicks Log in button.
		    Then user should see Wrong username or password message
		
		    Examples:
		      | username                       | password                          |
		      | Employee21Employee21Employee21 | Employee123                       |
		      | Employee21                     | Employee123Employee123Employee123 |
		      | Employee21Employee21Employee21 | Employee123Employee123Employee123 |	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#2-User can not login with any invalid credentials
	#     -"Wrong username or password." should be displayed for invalid credentials
	#     -"Please fill out this field" message should be displayed if the password or username is empty
	#h4.
	@MTSK-384
	Scenario Outline: Verify that user can not login with empty credentials
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    And user clicks Log in button.
		    Then user should see Please fill out this field message
		
		    Examples:
		      | username   | password    |
		      |            | Employee123 |
		      | Employee21 |             |
		      |            |             |	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#{color:#172b4d}User can see the password in a form of dots by default
	#User can see the password explicitly if needed{color}
	@MTSK-385
	Scenario Outline: Verify that user should see the password in form of dots by default and should see the password explicitly if needed
		Given user is on the login page of MeetSky application.
		    When user enters below "<username>" and "<password>"
		    Then user should see password in form of dots.
		    When user clicks the eye button
		    Then user should see password explicitly.
		
		    Examples:
		      | username   | password    |
		      | Employee21 | Employee123 |	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#{color:#172b4d}5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link{color}
	@MTSK-386
	Scenario: Verify that user see 'forgot password' link and can see "Reset Password" button on the next page after clicking on forget password link.
		Given user is on the login page of MeetSky application.
		    When user clicks Forgot password? link.
		    Then user should see the page contains Reset Password button.	

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#{color:#de350b}_*Acceptance Criteria:*_{color}
	#
	#{color:#172b4d}6-User can see valid placeholders on Username and Password fields{color}
	@MTSK-387
	Scenario: Verify that user should see valid placeholders for Username and Password fields
		Given user is on the login page of MeetSky application.
		    Then user should see correct Username and Password placeholders.