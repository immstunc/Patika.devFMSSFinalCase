Feature: User Signup

  @appium
  Scenario: Successful signup with valid inputs
    Given User opens app
    When User navigates to the signup page
    When User selects individual mode
    And User fills in the required fields with valid data
    And User clicks the gender
    And User clicks the next button
    And User fills e mail input
    And User fills phone number input
    And User fills password input
    And User fills the confirm password input
    And password and confirm password inputs should be same
    And User clicks the next button
    And User fills driver's licence ID
    And User fills driving licence taking place
    And User choose the date of taking licence
    And User choose the licence group from the dropdown menu
    And User agrees to the KVKK terms
    And User submits the signup form
    Then User should receive a confirmation email
    And User should be redirected to the login page

  @appium
  Scenario: Show alert when required field is left empty
    Given User opens app
    When User navigates to the signup page
    And User leaves the name field empty
    And User moves to the last name input field
    Then An alert should be displayed for the empty name field

  @appium
  Scenario: Corporate signup and redirect to corporate login
    Given User opens app
    When User selects corporate mode
    And User navigates to the corporate signup page
    And User fills the tax number input
    And User fills the company name input
    And User fills contact name input
    And User clicks the next button
    And User fills e mail input
    And User fills phone number input
    And User fills password input
    And User fills the confirm password input
    And password and confirm password inputs should be same
    And User agrees to the KVKK terms
    And User submits the signup form
    Then User should be redirected to the corporate login page

  @appium
  Scenario: Corporate signup without accepting terms and conditions
    Given User opens app
    When User selects corporate mode
    And User navigates to the corporate signup page
    And User fills the tax number input
    And User fills the company name input
    And User fills contact name input
    And User clicks the next button
    And User fills e mail input
    And User fills phone number input
    And User fills password input
    And User fills the confirm password input
    And password and confirm password inputs should be same
    But User does not agree to the KVKK terms
    And User submits the signup form
    Then An alert should be displayed indicating that accepting terms is mandatory

  @appium
  Scenario: Individual signup without accepting terms and conditions
    Given User opens app
    When User navigates to the signup page
    When User selects individual mode
    And User fills in the required fields with valid data
    But User does not agree to the KVKK terms
    And User submits the signup form
    Then An alert should be displayed indicating that accepting terms is mandatory