Feature: Customer Support Chat Feature

  Scenario: Initiate a Support Chat Session
    Given the user is logged into the app
    When the user navigates to the support section
    And the user clicks on the "Start Chat" button
    Then the app should open a chat window with a support agent

  Scenario: Send a Message in Support Chat
    Given the chat window is open
    When the user types a message in the chat input box
    And the user clicks the "Send" button
    Then the message should appear in the chat history

  Scenario: End a Support Chat Session
    Given the user is in an active chat session
    When the user clicks on the "End Chat" button
    Then the chat session should be terminated
    And the app should return to the support section
