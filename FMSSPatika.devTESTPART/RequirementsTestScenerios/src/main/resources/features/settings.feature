Feature: Update Profile Settings

  @appium
  Scenario: User updates their profile settings successfully
    Given User opens app
    When User navigates to the login page
    When User selects individual mode
    And User enters valid username and password
    And User submits the login form
    And User should be redirected to the homepage
    And User clicks profile settings
    When User updates their profile information
    Then The profile information should be updated successfully
