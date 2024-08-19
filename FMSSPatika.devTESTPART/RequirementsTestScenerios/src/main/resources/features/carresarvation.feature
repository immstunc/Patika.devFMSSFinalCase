Feature: Car Reservation

  @appium
  Scenario: Successful Car Reservation
    Given User opens app
    When User logs in with valid credentials
    And User navigates to the car reservation page
    And User selects a car category
    And User enters the date and time for pickup and return
    And User enters valid payment details
    And User clicks on "Reserve Now" button
    Then Reservation should be successful
    And User should see the reservation details page


  @appium
  Scenario: Invalid Date Selection
    Given User opens app
    When User navigates to the car reservation page
    And User selects a past date or invalid date
    And User clicks on "Reserve Now" button
    Then An "Invalid date" alert should be displayed
    And Reservation should not be successful