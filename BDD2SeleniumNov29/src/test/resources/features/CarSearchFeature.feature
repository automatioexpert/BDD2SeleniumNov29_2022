Feature: validation of car search page
  In order to validate car search
  as a buyer
  I navigate to https://www.carsales.com.au

  Scenario: Searching of a new car
    Given I am on the homepage https://www.carsales.com.au/
    When I am move to Cars for Sale menu
    Then I click on All cars
    And I click on Make
    And Select Make as "Audi"
    And I click on Search button
    Then I see a list of searched Cars
    And The page title should match "Audi cars for sale in Australia - carsales.com.au"
