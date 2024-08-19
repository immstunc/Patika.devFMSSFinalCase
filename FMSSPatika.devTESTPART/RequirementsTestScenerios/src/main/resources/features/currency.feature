Feature: Multi-Currency Support

  Scenario: Selecting a Currency
    Given User opens the app
    And User is on the currency selection page
    When User selects a currency from the dropdown
    Then Application should display prices in the selected currency

  Scenario: Displaying Prices in the Selected Currency
    Given User opens the app
    And User has selected a different currency
    When User navigates to the product page
    Then Product prices should be displayed in the selected currency

  Scenario: Retaining Currency Selection After App Restart
    Given User opens the app
    And User has selected a different currency
    When User closes and reopens the app
    Then Application should retain the selected currency after app restart
