
Feature: :F06_Shopping Cart | Users can manage their shopping cart

  @smoke @regression
  Scenario: Verify adding a product to the cart
    Given the user is on the homepage
    When the user selects a product
    And the user clicks on "Add to Cart"
    And the user navigates to their shopping cart
    Then the selected product should be visible in the shopping cart

  @regression
  Scenario: Verify updating the quantity of an item in the cart
    Given the user has items in their shopping cart
    When the user updates the quantity of an item
    Then the cart should reflect the updated quantity

  @regression
  Scenario: Verify applying an invalid discount code
    Given the user has items in their shopping cart
    When the user enters an invalid discount code
    Then an error message should appear stating "Invalid coupon code"

  @regression
  Scenario: Verify removing an item from the shopping cart
    Given the user has items in their shopping cart
    When the user removes an item
    Then the item should no longer appear in the shopping cart
