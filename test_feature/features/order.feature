Feature: Order
    # Scenario1
    Scenario: Navigating to Hiring Clients filter field and select one value filter via Prequal section
        Given I open a browser
        When I navigate to the 'login' page
        And I login as :
            | userName | luis@accelone.com |
            | password | test1234          |
        And I am on a 'PreQual' section detail page
        And I click on 'Hiring Clients' filter field
        And select value 'Acco' from that lists displayed
        Then the value selected must display all related HCs 'Acco' to the page

    