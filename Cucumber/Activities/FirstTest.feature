@FirstExample
Feature: Basic Syntax
 
  @FirstScenarion @SmokeTest
  Scenario: Basic Test for Selenium
    Given the user is on the TS homepage
    When the user clicks on the About Us link
    Then the user is redirected to the About page
    
