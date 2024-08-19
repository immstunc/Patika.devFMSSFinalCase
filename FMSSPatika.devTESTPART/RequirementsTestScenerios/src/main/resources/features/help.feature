Feature: In-App Help & Support & FAQ

  Scenario: Access In-App Help Section
    Given the user is logged into the app
    When the user navigates to the Help & Support section
    Then the app should display a list of help topics

  Scenario: Search for a Topic in FAQ
    Given the user is in the FAQ section
    When the user enters a search query in the search bar
    And the user submits the search
    Then the app should display relevant FAQ entries

  Scenario: Contact Support via In-App Messaging
    Given the user is in the Help & Support section
    When the user selects the "Contact Support" option
    And the user types a message in the support input box
    And the user clicks the "Send" button
    Then the app should send the message to customer support
    And the user should receive an acknowledgment message
