@smoke
Feature: User Registration Tests
As a user
I want to register with various email and password combinations
So that I can validate different registration scenarios

  Scenario: Successful registration with valid email and password
    Given the user navigates to the "Create an Account" page
    When the user enters their first name and last name
    And the user provides a valid email and a strong password
    And the user confirms the password correctly
    And the user clicks the "Create Account" button
    Then the user should be redirected to their new account dashboard

  Scenario: Registration with invalid email format
    Given the user navigates to the "Create an Account" page
    When the user enters their first name and last name
    And the user provides an invalid email format and a strong password
    And the user confirms the password correctly
    And the user clicks the "Create Account" button
    Then an error message indicating "Invalid email format" should appear



  Scenario: Registration with mismatched passwords
    Given the user navigates to the "Create an Account" page
    When the user enters their first name and last name
    And the user provides a valid email and a strong password
    And the user enters a different password in the "Confirm Password" field
    And the user clicks the "Create Account" button
    Then an error message indicating "Passwords do not match" should appear

  Scenario: user register with missing required field
    Given the user navigates to the "Create an Account" page
    When the user enters their first name and last name
    And the user provides a valid email and a strong password
    And the user clicks the "Create Account" button
    Then an error message indicating "Please fill in all required fields" should appear



