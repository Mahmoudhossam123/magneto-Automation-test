

Feature: :F03_What's New Page | Users can explore the latest products

  @smoke @complete
  Scenario: Navigate to the "What's New" page
    Given the user is on the homepage
    When the user clicks on the "What's New" button
    Then the user should be redirected to the "What's New" page

  @regression @complete
  Scenario: Verify that new products are displayed with complete details

    Given the new products are loaded
    Then each product should have an image, a name, and a price

  @regression @complete
  Scenario: Verify the "Compare Product" function

    Given the user selects any product
    And the user clicks on the "Compare Product" button
    Then the product should be added to the "Compare Products" list

  @regression @complete
  Scenario: Verify the "Add to Wishlist" function

    Given the user clicks on the "Add to Wishlist" button
    And the user enters a valid email address
    And the user enters a valid password
    Then the product should be added to the wishlist
