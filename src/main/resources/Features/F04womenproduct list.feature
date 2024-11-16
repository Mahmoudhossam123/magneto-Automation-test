
@regression
Feature: F04_Women Product List | Product List Filtering Functionality
  As a user
  I want to filter products by category
  So that I can view specific types of products efficiently

  Scenario: Verify product filtering by "Hoodies & Sweatshirts" category
    Given the user is on the homepage
    When the user selects the "Women" category
    And the user selects the "Hoodies & Sweatshirts" category from the filter options
    Then the user should be redirected to the "Hoodies & Sweatshirts" product page


  @complete
  Scenario: Verify product filtering by "Jackets" category

    Given the user selects the "Jackets" category from the filter options
    Then the user should be redirected to the "Jackets" product page

 Scenario: Verify product filtering by tees category
   Given the user selects the "Tees" category from the filter options
   Then the user should be redirected to the "Tees" product page


  @complete

 Scenario: Verify product filtering by bt category
    Given the user selects the BT category from the filter options
    Then the user should be redirected to the BT product page


  @complete

 Scenario: Verify product filtering by pants category
    Given the user selects the "Pants" category from the filter options
    Then the user should be redirected to the "Pants" product page
  @complete

 Scenario: Verify product filtering by shorts category
    Given the user selects the "Shorts" category from the filter options
    Then the user should be redirected to the "Shorts" product page

