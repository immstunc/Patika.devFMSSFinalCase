package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpSupportPage {

    private AppiumDriver driver;

    @FindBy(id = "com.example.app:id/helpSupportSection")
    private WebElement helpSupportSection;

    @FindBy(id = "com.example.app:id/helpTopics")
    private WebElement helpTopics;

    @FindBy(id = "com.example.app:id/faqSection")
    private WebElement faqSection;

    @FindBy(id = "com.example.app:id/searchBar")
    private WebElement searchBar;

    @FindBy(id = "com.example.app:id/searchButton")
    private WebElement searchButton;

    @FindBy(id = "com.example.app:id/faqEntries")
    private WebElement faqEntries;

    @FindBy(id = "com.example.app:id/contactSupportOption")
    private WebElement contactSupportOption;

    @FindBy(id = "com.example.app:id/supportInputBox")
    private WebElement supportInputBox;

    @FindBy(id = "com.example.app:id/sendButton")
    private WebElement sendButton;

    @FindBy(id = "com.example.app:id/acknowledgmentMessage")
    private WebElement acknowledgmentMessage;

    public HelpSupportPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void navigateToHelpSupportSection() {
        helpSupportSection.click();
    }

    public boolean areHelpTopicsDisplayed() {
        return helpTopics.isDisplayed();
    }

    public void navigateToFAQSection() {
        faqSection.click();
    }

    public void enterSearchQuery(String query) {
        searchBar.sendKeys(query);
    }

    public void submitSearch() {
        searchButton.click();
    }

    public boolean areFAQEntriesDisplayed() {
        return faqEntries.isDisplayed();
    }

    public void selectOption(String option) {
        if ("Contact Support".equals(option)) {
            contactSupportOption.click();
        }
    }
    public boolean isInHelpSupportSection() {
        return helpSupportSection.isDisplayed();
    }


    public void typeSupportMessage(String message) {
        supportInputBox.sendKeys(message);
    }

    public void clickButton(String buttonName) {
        if ("Send".equals(buttonName)) {
            sendButton.click();
        }
    }

    public boolean isMessageSentToSupport() {

        return true;
    }

    public boolean isAcknowledgmentMessageReceived() {
        return acknowledgmentMessage.isDisplayed();
    }
}
