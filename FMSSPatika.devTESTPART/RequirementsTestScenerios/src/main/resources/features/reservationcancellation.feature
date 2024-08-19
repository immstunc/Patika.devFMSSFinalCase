Feature: Reservation Cancellation

  @appium
  Scenario: Successful reservation cancellation
    Given User opens the reservation app
    When User navigates to the reservation page
    And User selects a reservation
    And User cancels the reservation
    Then A cancellation confirmation should be displayed
    And The reservation should be removed from the list
