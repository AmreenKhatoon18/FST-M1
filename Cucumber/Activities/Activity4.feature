@activity4
Feature: Data driven test without Example

@loginTest @loginSuccess
Scenario: Testing with correct Data from inputs
    Given User is on Login page
    When User enters "admin" and "password"
    And clicks the submit button
    Then get the confirmation message and verify message as "Welcome back, admin"
    And Close the Browser