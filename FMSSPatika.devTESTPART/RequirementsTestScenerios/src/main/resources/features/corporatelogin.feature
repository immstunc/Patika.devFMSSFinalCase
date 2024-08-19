Feature: Corporate login

  @appium
  Scenario: Corporate user logs in successfully
    Given User opens app
    When User selects corporate mode
    When User enters a valid corporate username
    And User enters valid username and password
    And User clicks on the "Login" button
    Then User should be logged in successfully
    Then User should be redirected to the homepage