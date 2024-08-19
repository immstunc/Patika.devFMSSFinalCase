package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HelpSupportPage;

import static org.junit.Assert.assertTrue;

public class HelpSupportSteps {

    private AppiumDriver driver;
    private HelpSupportPage helpSupportPage;

    public HelpSupportSteps(AppiumDriver driver) {
        this.driver = driver;
        this.helpSupportPage = new HelpSupportPage(driver);
    }

    @Given("the user is logged into the app")
    public void userIsLoggedIntoApp() {
        // Code to verify the user is logged in, or perform login if necessary
    }

    @When("the user navigates to the Help & Support section")
    public void userNavigatesToHelpSupportSection() {
        helpSupportPage.navigateToHelpSupportSection();
    }

    @Then("the app should display a list of help topics")
    public void appShouldDisplayListOfHelpTopics() {
        assertTrue("Help topics should be displayed", helpSupportPage.areHelpTopicsDisplayed());
    }

    @Given("the user is in the FAQ section")
    public void userIsInFAQSection() {
        helpSupportPage.navigateToFAQSection();
    }

    @When("the user enters a search query in the search bar")
    public void userEntersSearchQueryInSearchBar() {
        helpSupportPage.enterSearchQuery("account");
    }

    @When("the user submits the search")
    public void userSubmitsSearch() {
        helpSupportPage.submitSearch();
    }

    @Then("the app should display relevant FAQ entries")
    public void appShouldDisplayRelevantFAQEntries() {
        assertTrue("Relevant FAQ entries should be displayed", helpSupportPage.areFAQEntriesDisplayed());
    }

    @Given("the user is in the Help & Support section")
    public void userIsInHelpSupportSection() {
        helpSupportPage.navigateToHelpSupportSection();
        assertTrue("User is not in the Help & Support section", helpSupportPage.isInHelpSupportSection());
    }


    @When("the user selects the {string} option")
    public void userSelectsOption(String option) {
        helpSupportPage.selectOption(option);
    }

    @When("the user types a message in the support input box")
    public void userTypesMessageInSupportInputBox() {
        helpSupportPage.typeSupportMessage("I need help with my account.");
    }

    @When("the user clicks the {string} button")
    public void userClicksButton(String buttonName) {
        helpSupportPage.clickButton(buttonName);
    }

    @Then("the app should send the message to customer support")
    public void appShouldSendMessageToCustomerSupport() {
        assertTrue("Message should be sent to customer support", helpSupportPage.isMessageSentToSupport());
    }

    @Then("the user should receive an acknowledgment message")
    public void userShouldReceiveAcknowledgmentMessage() {
        assertTrue("Acknowledgment message should be received", helpSupportPage.isAcknowledgmentMessageReceived());
    }
}
