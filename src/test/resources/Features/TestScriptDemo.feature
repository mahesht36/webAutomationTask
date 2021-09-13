Feature: Test Script Demo Feature

  Scenario: Adding the products to wish list & buying the lowest price product.
    Given I add four different product to my wishlist
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    When I search for lowest price product
    And I am able to add the lowest price product to my cart
    Then I am able to verify the item in my cart