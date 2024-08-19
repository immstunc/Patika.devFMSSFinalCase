Feature: Vehicle Detail Viewing

  @appium
  Scenario: User views details of a selected vehicle
    Given User is on the vehicle search results page
    When User selects a vehicle from the list
    Then User should see the vehicle detail page with all relevant information
    And User should see options to book the vehicle, view additional photos, and read reviews
