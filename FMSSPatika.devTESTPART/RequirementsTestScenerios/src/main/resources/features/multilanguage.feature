Feature: Multi-Language Support

  Scenario: Verify App Launches with Default Language
    Given the app is installed on the device
    When the user opens the app
    Then the app should display the content in the default language

  Scenario: Switch Language from Default to French
    Given the user is on the home screen
    When the user navigates to the settings page
    And the user selects French from the language options
    Then the app should display the content in French
    And the selected language should persist across app restarts

  Scenario: Verify Language Changes Across All Screens
    Given the app is running in a specific language
    When the user navigates through various screens like profile, settings, and help
    Then the app should consistently display all content in the selected language
