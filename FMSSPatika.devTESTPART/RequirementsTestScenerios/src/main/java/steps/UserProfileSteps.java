package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserProfilePage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserProfileSteps {
    UserProfilePage userProfilePage = null;

    @Given("The user is on the profile management page")
    public void userIsOnProfileManagementPage() {
        userProfilePage = new UserProfilePage();
        // Code to navigate to the profile management page if not directly initialized
    }

    @When("The user updates their profile information with valid data")
    public void userUpdatesProfileInformationWithValidData() {
        userProfilePage.updateProfile("John Doe", "1234567890", "john.doe@example.com");
    }

    @When("The user enters an invalid email address")
    public void userEntersInvalidEmailAddress() {
        userProfilePage.updateProfile("John Doe", "1234567890", "invalid-email");
    }

    @When("The user leaves mandatory fields (like name or phone number) empty")
    public void userLeavesMandatoryFieldsEmpty() {
        userProfilePage.updateProfile("", "", "john.doe@example.com");
    }

    @When("The user saves the changes")
    public void userSavesChanges() {
        userProfilePage.saveChanges();
    }

    @Then("The profile should be updated successfully, and a confirmation message should be displayed")
    public void profileShouldBeUpdatedSuccessfully() {
        boolean isUpdateSuccessful = userProfilePage.isProfileUpdateSuccessful();
        assertTrue("Profile should be updated successfully", isUpdateSuccessful);

        String confirmationMessage = userProfilePage.getConfirmationMessage();
        assertEquals("Confirmation message should be displayed", "Profile updated successfully", confirmationMessage);
    }

    @Then("An error message should be displayed, indicating that the email address is invalid")
    public void errorMessageForInvalidEmail() {
        String errorMessage = userProfilePage.getErrorMessage();
        assertEquals("Error message should indicate that the email is invalid", "Invalid email address", errorMessage);
    }

    @Then("An error message should be displayed, indicating that all required fields must be filled")
    public void errorMessageForMissingFields() {
        String errorMessage = userProfilePage.getErrorMessage();
        assertEquals("Error message should indicate that required fields are missing", "All required fields must be filled", errorMessage);
    }
}
