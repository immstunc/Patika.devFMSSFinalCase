Feature: Vehicle Search Without Registration

  @appium
  Scenario: User searches for a vehicle without registration
    Given User opens the app
    When User navigates to the vehicle search page
    And User selects a vehicle category
    And User enters the location and date for the vehicle search
    And User clicks on the search button
    Then User should see a list of available vehicles
