
@smoke
Feature: F02_Login | Users can use the login functionality to access their accounts
  As a user
  I want to log in using various email and password combinations
  So that I can verify the login functionality and error handling

  Scenario: Successful login with valid email and password
    Given the user navigates to the "Login" page
    When the user enters a valid email address
    And the user enters a valid password
    Then the user should be redirected to their account dashboard


  Scenario: Login attempt with invalid email and valid password
    Given the user navigates to the "Login" page
    When the user enters an invalid email address
    And the user enters a valid password
    Then an error message indicating "Invalid email address" should be displayed

  Scenario: Login attempt with valid email and invalid password
    Given the user navigates to the "Login" page
    When the user enters a valid email address
    And the user enters an incorrect password
    Then an error message indicating "Incorrect password" should be displayed


  Scenario: Login attempt with invalid email and invalid password
    Given the user navigates to the "Login" page
    When the user enters an invalid email address
    And the user enters an incorrect password
    Then an error message indicating "Invalid email or password" should be displayed

