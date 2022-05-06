@Order
Feature: Order

        @Shop
        Scenario: As Customer I order a product
            Given I visit the app url
             When I see the home page
              And I click on category: Laptops
              And I click on product: MacBook Pro
              And I see product name label
              And I see product price label
              And I see product description
              And I click on Add To Cart button and verify popup
              And I click on Cart menu
              And I click on Place Order button
              And I enter name : "Test"
              And I enter Country : "PK"
              And I enter City : "LHR"
              And I enter Credit Card : "1111222233334444"
              And I enter Month : "12"
              And I enter Year : "2025"
              And I click on Purchase button
             Then I see thank you page
