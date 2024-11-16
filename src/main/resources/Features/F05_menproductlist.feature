
@regression
Feature: :F05_Men's Product List | Product List Filtering Functionality
  As a user
  I want to filter products by category
  So that I can view specific types of men's products efficiently

  @complete
  Scenario: Verify product filtering by "Hoodies & Sweatshirts" category
    Given the user is on the homepage
    When the user selects the "Men's" category
    And the user selects the "Hoodies & Sweatshirts" category from the men's options
    Then the user should be redirected to the "Men's Hoodies & Sweatshirts" page

  @complete
  Scenario: Verify product filtering by "Jackets" category

    Given the user selects the "Jackets" category from the men's options
    Then the user should be redirected to the "Men's Jackets" page

  @complete
  Scenario: Verify product filtering by "Tees" category
    Given the user selects the "Tees" category from the men's options
    Then the user should be redirected to the "Men's Tees" page

  @complete
  Scenario: Verify product filtering by "Tanks" category
    Given the user selects the "Tanks" category from the men's options
    Then the user should be redirected to the "Men's Tanks" page

  @complete
  Scenario: Verify product filtering by "Pants" category
    Given the user selects the "Pants" category from the men's options
    Then the user should be redirected to the "Men's Pants" page

  @complete
  Scenario: Verify product filtering by "Shorts" category
    Given the user selects the "Shorts" category from the men's options
    Then the user should be redirected to the "Men's Shorts" page
