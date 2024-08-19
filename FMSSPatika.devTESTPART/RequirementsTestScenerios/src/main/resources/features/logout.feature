Feature: Logout from Profile Screen

  @appium
  Scenario: User logs out successfully from the profile screen
    Given User is logged in as an individual customer
    When User navigates to the profile screen using the bottom navbar
    And User clicks on the "Logout" button
    Then User should be logged out
    And User should be redirected to the login screen



  @appium
  Scenario: Corporate user logs out successfully from the profile screen
    Given User opens app
    When User selects corporate mode
    When User enters a valid corporate username
    And User enters valid username and password
    And User clicks on the "Login" button
    Then User should be logged in successfully
    When User navigates to the profile screen using the bottom navbar
    And User clicks on the "Logout" button
    Then User should be logged out
    And User should be redirected to the login screen



  @appium
  Scenario: User tries to navigate back after logging out
    Given User should be logged out
    When User clicks the back button on the device
    Then User should stay on the login screen
    And User should not be able to return to the profile screen
