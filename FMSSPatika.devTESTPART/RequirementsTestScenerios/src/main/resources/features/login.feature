Feature: User Login

  @appium
  Scenario: Successful login with valid credentials
    Given User opens app
    When User navigates to the login page
    When User selects individual mode
    And User enters valid username and password
    And User submits the login form
    Then User should be redirected to the homepage

  @appium
  Scenario: Unsuccessful login with invalid credentials
    Given User opens app
    When User navigates to the login page
    When User selects individual mode
    And User enters invalid username and password
    And User submits the login form
    Then An error message should be displayed indicating invalid credentials

  @appium
  Scenario: Unsuccessful login with empty fields
    Given User opens app
    When User navigates to the login page
    When User selects individual mode
    And User leaves the username or password field empty
    And User submits the login form
    Then An error message should be displayed indicating that all fields are required

  @appium
  Scenario: Account lockout after multiple failed login attempts
    Given User opens app
    When User navigates to the login page
    When User selects individual mode
    And User enters invalid credentials multiple times
    Then User account should be locked and a lockout message displayed

