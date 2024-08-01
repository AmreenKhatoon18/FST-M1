@activity5
Feature: Data driven test with Example

@loginTest @loginSuccess
Scenario: Testing with correct Data from inputs
    Given User is on Login page
    When User enters "Usernames" and "Passwords"
    And clicks the submit button
    Then get the confirmation message and verify message as "Message"
    And Close the Browser

    Examples: 
      | Usernames  | Passwords 	| Message 						 |
      | admin 		 |  password 	| Welcome Back, Admin  |
      | admin1		 |  password1 | Invalid Credentials  |
