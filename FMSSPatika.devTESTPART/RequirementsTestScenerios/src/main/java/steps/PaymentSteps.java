package steps;

import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaymentPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PaymentSteps {
    PaymentPage paymentPage = null;

    @Given("The user is on the payment page")
    public void userIsOnPaymentPage() {
        paymentPage = new PaymentPage();
    }

    @When("The user enters credit card information")
    public void userEntersCreditCardInformation() {
        paymentPage.enterCreditCardInformation("4111111111111111", "12/24", "123");
    }

    @When("The user clicks on {string}")
    public void userClicksOn(String button) {
        if (button.equals("Complete Payment")) {
            paymentPage.clickCompletePayment();
        }
    }

    @Then("The payment is successful, and the user receives a payment confirmation")
    public void paymentIsSuccessful() {
        boolean isConfirmationDisplayed = paymentPage.isPaymentConfirmationDisplayed();
        assertTrue("Payment confirmation should be displayed", isConfirmationDisplayed);
    }

    @When("The user enters invalid credit card information")
    public void userEntersInvalidCreditCardInformation() {
        paymentPage.enterCreditCardInformation("0000000000000000", "01/20", "000");
    }

    @Then("An error message {string} is displayed, and the payment fails")
    public void errorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = paymentPage.getErrorMessage();
        assertEquals("Error message should be displayed", expectedMessage, actualMessage);
    }
}
