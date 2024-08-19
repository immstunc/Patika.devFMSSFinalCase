package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {
    private AppiumDriver driver;

    // Constructor
    public UserProfilePage() {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/nameField")
    private WebElement nameField;

    @FindBy(id = "com.example.app:id/phoneField")
    private WebElement phoneField;

    @FindBy(id = "com.example.app:id/emailField")
    private WebElement emailField;

    @FindBy(id = "com.example.app:id/saveButton")
    private WebElement saveButton;

    @FindBy(id = "com.example.app:id/confirmationMessage")
    private WebElement confirmationMessage;

    @FindBy(id = "com.example.app:id/errorMessage")
    private WebElement errorMessage;

    // Page Methods
    public void updateProfile(String name, String phone, String email) {
        if (!name.isEmpty()) {
            nameField.sendKeys(name);
        }
        if (!phone.isEmpty()) {
            phoneField.sendKeys(phone);
        }
        emailField.sendKeys(email);
    }

    public void saveChanges() {
        saveButton.click();
    }

    public boolean isProfileUpdateSuccessful() {

        return confirmationMessage.isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
