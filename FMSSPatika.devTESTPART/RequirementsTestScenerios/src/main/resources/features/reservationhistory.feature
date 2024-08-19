Feature: View Past Reservations

  @appium
  Scenario: User views past reservations
    Given User opens the app
    When User navigates to the reservation history page
    And User selects a reservation to view
    Then User should see the reservation details
