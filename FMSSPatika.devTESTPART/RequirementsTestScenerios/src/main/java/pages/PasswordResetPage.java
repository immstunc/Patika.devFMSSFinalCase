package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
    private AppiumDriver driver;

    // Constructor
    public PasswordResetPage() {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/forgotPasswordButton")
    private WebElement forgotPasswordButton;

    @FindBy(id = "com.example.app:id/emailField")
    private WebElement emailField;

    @FindBy(id = "com.example.app:id/resetPasswordButton")
    private WebElement resetPasswordButton;

    @FindBy(id = "com.example.app:id/tokenGeneratedMessage")
    private WebElement tokenGeneratedMessage;

    @FindBy(id = "com.example.app:id/emailSentMessage")
    private WebElement emailSentMessage;

    @FindBy(id = "com.example.app:id/errorMessage")
    private WebElement errorMessage;

    // Page Methods
    public void clickForgotPasswordButton() {
        forgotPasswordButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public boolean isTokenGenerated() {

        return tokenGeneratedMessage.isDisplayed();
    }

    public boolean isPasswordResetEmailSent() {

        return emailSentMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
