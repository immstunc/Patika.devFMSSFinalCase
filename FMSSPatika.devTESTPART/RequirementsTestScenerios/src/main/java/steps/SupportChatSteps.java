package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SupportChatPage;

import static org.junit.Assert.assertTrue;

public class SupportChatSteps {

    private AppiumDriver driver;
    private SupportChatPage supportChatPage;

    public SupportChatSteps(AppiumDriver driver) {
        this.driver = driver;
        this.supportChatPage = new SupportChatPage(driver);
    }

    @Given("the user is logged into the app")
    public void userIsLoggedIntoApp() {

    }

    @When("the user navigates to the support section")
    public void userNavigatesToSupportSection() {
        supportChatPage.navigateToSupportSection();
    }

    @When("the user clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        supportChatPage.clickButton(buttonName);
    }

    @Then("the app should open a chat window with a support agent")
    public void appShouldOpenChatWindow() {
        assertTrue("Chat window should be opened", supportChatPage.isChatWindowOpen());
    }

    @Given("the chat window is open")
    public void chatWindowIsOpen() {
        assertTrue("Chat window should be open", supportChatPage.isChatWindowOpen());
    }

    @When("the user types a message in the chat input box")
    public void userTypesMessageInChatInputBox() {
        supportChatPage.typeMessage("Hello, I need help.");
    }

    @When("the user clicks the {string} button")
    public void userClicksSendButton(String buttonName) {
        supportChatPage.clickButton(buttonName);
    }

    @Then("the message should appear in the chat history")
    public void messageShouldAppearInChatHistory() {
        assertTrue("Message should appear in chat history", supportChatPage.isMessageInChatHistory("Hello, I need help."));
    }

    @Given("the user is in an active chat session")
    public void userIsInActiveChatSession() {
        assertTrue("Chat session should be active", supportChatPage.isChatWindowOpen());
    }

    @Then("the chat session should be terminated")
    public void chatSessionShouldBeTerminated() {
        assertTrue("Chat session should be terminated", supportChatPage.isChatSessionTerminated());
    }

    @Then("the app should return to the support section")
    public void appShouldReturnToSupportSection() {
        assertTrue("App should return to the support section", supportChatPage.isInSupportSection());
    }
}
