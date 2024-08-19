package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    private final AppiumDriver driver;

    // Constructor
    public SettingsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/usernameField")
    private WebElement usernameField;

    @FindBy(id = "com.example.app:id/emailField")
    private WebElement emailField;

    @FindBy(id = "com.example.app:id/phoneField")
    private WebElement phoneField;

    @FindBy(id = "com.example.app:id/saveButton")
    private WebElement saveButton;

    @FindBy(id = "com.example.app:id/successMessage")
    private WebElement successMessage;

    @FindBy(id = "com.example.app:id/errorMessage")
    private WebElement errorMessage;

    // Page Methods
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
