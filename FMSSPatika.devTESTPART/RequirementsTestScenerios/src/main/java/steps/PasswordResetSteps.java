package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PasswordResetPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PasswordResetSteps {
    PasswordResetPage passwordResetPage = null;

    @Given("The user is on the login screen and clicks the {string} button")
    public void userOnLoginScreenAndClicksButton(String button) {
        passwordResetPage = new PasswordResetPage();
        if (button.equals("Forgot Password")) {
            passwordResetPage.clickForgotPasswordButton();
        }
    }

    @When("The user enters a registered email address")
    public void userEntersRegisteredEmailAddress() {
        passwordResetPage.enterEmail("registered@example.com"); // Example registered email
    }

    @When("The user enters an unregistered email address")
    public void userEntersUnregisteredEmailAddress() {
        passwordResetPage.enterEmail("unregistered@example.com"); // Example unregistered email
    }

    @When("The user clicks the {string} button")
    public void userClicksButton(String button) {
        if (button.equals("Reset Password")) {
            passwordResetPage.clickResetPasswordButton();
        }
    }

    @Then("A secure token is generated")
    public void secureTokenIsGenerated() {
        boolean isTokenGenerated = passwordResetPage.isTokenGenerated();
        assertTrue("A secure token should be generated", isTokenGenerated);
    }

    @Then("A password reset email is sent to the registered email address")
    public void passwordResetEmailIsSent() {
        boolean isEmailSent = passwordResetPage.isPasswordResetEmailSent();
        assertTrue("A password reset email should be sent", isEmailSent);
    }

    @Then("An error message is displayed, indicating that the email address is not registered")
    public void errorMessageIsDisplayed() {
        String actualMessage = passwordResetPage.getErrorMessage();
        assertEquals("Error message should indicate that the email is not registered", "Email address is not registered", actualMessage);
    }

    @Then("No password reset email is sent")
    public void noPasswordResetEmailIsSent() {
        boolean isEmailSent = passwordResetPage.isPasswordResetEmailSent();
        assertTrue("No password reset email should be sent", !isEmailSent);
    }
}
