Feature: View and Download Invoice

  @appium
  Scenario: User views and downloads an invoice
    Given User opens the app
    When User navigates to the invoice page
    And User selects an invoice to view
    Then User should see the invoice details
    When User chooses to download the invoice
    Then The invoice should be downloaded successfully
