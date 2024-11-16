@smoke
Feature: :F07_Check Out | Users Checkout

  Scenario: Navigate to the checkout page
    Given the user is on the homepage
    When the user selects a product
    And the user clicks on "Add to Cart"
    Then the user redirected to the checkout page

  @complete
  Scenario: Guest checkout without creating an account

    Given the user enters valid shipping and payment details
    And the user clicks on "Next"
    And the user clicks on "Place Order"
    Then the user should be redirected to the success page

  @complete
  Scenario: Logged-in user checkout
    Given the user is on the homepage
    When the user selects a product
    And the user clicks on "Add to Cart"
    And the user redirected to the checkout page
    And the user logs into their account
    And the user clicks on "Next"
    And the user clicks on "Place Order"
    Then the user should be redirected to the success page
