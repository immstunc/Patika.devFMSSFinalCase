Feature: User Profile Management Use-Case

  @appium
  Scenario: Successful Profile Update
    Given The user is on the profile management page
    When The user updates their profile information with valid data
    And The user saves the changes
    Then The profile should be updated successfully, and a confirmation message should be displayed

  @appium
  Scenario: Profile Update with Invalid Email
    Given The user is on the profile management page
    When The user enters an invalid email address
    And The user saves the changes
    Then An error message should be displayed, indicating that the email address is invalid

  @appium
  Scenario: Profile Update with Missing Required Fields
    Given The user is on the profile management page
    When The user leaves mandatory fields  empty
    And The user saves the changes
    Then An error message should be displayed, indicating that all required fields must be filled