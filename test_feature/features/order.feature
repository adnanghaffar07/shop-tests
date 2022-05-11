Feature: Order
    # Scenario1
    Scenario: As a User I order a product
        Given I open a browser
        When I navigate to the 'https://www.demoblaze.com/' url
        And the 'PRODUCT STORE' text displays
        And I click on the 'Laptops' link
        And I click on the 'MacBook Pro' link
        And I see product name label
        And I see product price label
        And I see product description
        And I click on the 'Add to cart' link
        And I click on the 'Cart' link
        And I see the product 'MacBook Pro' available in the cart
        And I click on the 'Place Order' button
        And I enter payment information :
            | Attribute|Value|
            | name | Test  |
            | city | LHR   |
            | country | PK |
            | creditCard | 1111222233334444 |
            | month | 12 |
            | year | 2025 |
        And I click on the 'Purchase' button
        Then the 'Thank you for your purchase!' text displays

    