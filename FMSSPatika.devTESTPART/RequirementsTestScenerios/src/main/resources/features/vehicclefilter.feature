Feature: Vehicle Filtering

  @appium
  Scenario: User filters vehicles based on specific criteria
    Given User is on the vehicle search results page
    When User opens the filter options
    And User selects vehicle type as "SUV"
    And User selects price range as "100-200"
    And User selects additional options like "Automatic Transmission" and "Air Conditioning"
    And User applies the filters
    Then User should see the filtered list of vehicles
