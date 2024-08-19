Feature: Payment Use-Case

  @appium
  Scenario: Successful Payment
    Given The user is on the payment page
    When The user enters credit card information
    And The user clicks on "Complete Payment"
    Then The payment is successful, and the user receives a payment confirmation

  @appium
  Scenario: Invalid Credit Card Information Payment Attempt
    Given The user is on the payment page
    When The user enters invalid credit card information
    And The user clicks on "Complete Payment"
    Then An error message "Invalid card information" is displayed, and the payment fails
