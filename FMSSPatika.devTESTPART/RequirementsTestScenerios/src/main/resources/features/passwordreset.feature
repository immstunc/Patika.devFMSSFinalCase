Feature: Password Reset Functionality

  @appium
  Scenario: Successful Password Reset
    Given The user is on the login screen and clicks the "Forgot Password" button
    When The user enters a registered email address
    And The user clicks the "Reset Password" button
    Then A secure token is generated
    And A password reset email is sent to the registered email address

  @appium
  Scenario: Unsuccessful Password Reset with Unregistered Email
    Given The user is on the login screen and clicks the "Forgot Password" button
    When The user enters an unregistered email address
    And The user clicks the "Reset Password" button
    Then An error message is displayed, indicating that the email address is not registered
    And No password reset email is sent
