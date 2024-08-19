Feature: Search for a Vehicle Without Registering

  @appium
  Scenario: User searches for a vehicle without registering
    Given User opens the app
    When User navigates to the search page
    And User enters the vehicle details
    And User submits the search
    Then User should see the search results
    And User should not be prompted to register
