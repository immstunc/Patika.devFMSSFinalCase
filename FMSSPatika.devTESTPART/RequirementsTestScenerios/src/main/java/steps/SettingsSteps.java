package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingsPage;

import static org.junit.Assert.assertTrue;

public class SettingsSteps {

    private final SettingsPage settingsPage;

    public SettingsSteps(AppiumDriver driver) {
        this.settingsPage = new SettingsPage(driver);
    }

    @When("User navigates to the settings page")
    public void userNavigatesToTheSettingsPage() {

    }

    @When("User updates their profile information")
    public void userUpdatesProfileInformation() {
        settingsPage.enterUsername("newUsername");
        settingsPage.enterEmail("newEmail@example.com");
        settingsPage.enterPhone("1234567890");
        settingsPage.clickSaveButton();
    }

    @Then("The profile information should be updated successfully")
    public void profileShouldBeUpdatedSuccessfully() {
        assertTrue("Success message should be displayed", settingsPage.isSuccessMessageDisplayed());
    }
    @And("User clicks profile settings")
    public void userClicksProfileSettings() {
    }

    @When("User leaves required fields empty")
    public void userLeavesRequiredFieldsEmpty() {
        settingsPage.enterUsername("");
        settingsPage.enterEmail("");
        settingsPage.enterPhone("");
        settingsPage.clickSaveButton();
    }

    @Then("An error message should be displayed indicating that all fields are required")
    public void errorMessageForEmptyFieldsShouldBeDisplayed() {
        assertTrue("Error message should be displayed", settingsPage.isErrorMessageDisplayed());
    }


}
