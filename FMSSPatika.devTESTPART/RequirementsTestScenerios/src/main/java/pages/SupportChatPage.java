package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportChatPage {

    //Constructor
    private AppiumDriver driver;

    //Page Elements
    @FindBy(id = "com.example.app:id/supportSection")
    private WebElement supportSection;

    @FindBy(id = "com.example.app:id/startChatButton")
    private WebElement startChatButton;

    @FindBy(id = "com.example.app:id/chatWindow")
    private WebElement chatWindow;

    @FindBy(id = "com.example.app:id/chatInputBox")
    private WebElement chatInputBox;

    @FindBy(id = "com.example.app:id/sendButton")
    private WebElement sendButton;

    @FindBy(id = "com.example.app:id/chatHistory")
    private WebElement chatHistory;

    @FindBy(id = "com.example.app:id/endChatButton")
    private WebElement endChatButton;

    //Page Methods
    public SupportChatPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void navigateToSupportSection() {
        supportSection.click();
    }

    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Start Chat":
                startChatButton.click();
                break;
            case "Send":
                sendButton.click();
                break;
            case "End Chat":
                endChatButton.click();
                break;
        }
    }

    public void typeMessage(String message) {
        chatInputBox.sendKeys(message);
    }

    public boolean isChatWindowOpen() {
        return chatWindow.isDisplayed();
    }

    public boolean isMessageInChatHistory(String message) {
        return chatHistory.getText().contains(message);
    }

    public boolean isChatSessionTerminated() {
        return !chatWindow.isDisplayed();
    }

    public boolean isInSupportSection() {
        return supportSection.isDisplayed();
    }
}
