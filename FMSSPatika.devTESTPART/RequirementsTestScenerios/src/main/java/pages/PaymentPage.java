package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private AppiumDriver driver;

    // Constructor
    public PaymentPage() {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/creditCardNumber")
    private WebElement creditCardNumberField;

    @FindBy(id = "com.example.app:id/expiryDate")
    private WebElement expiryDateField;

    @FindBy(id = "com.example.app:id/cvv")
    private WebElement cvvField;

    @FindBy(id = "com.example.app:id/completePaymentButton")
    private WebElement completePaymentButton;

    @FindBy(id = "com.example.app:id/paymentConfirmation")
    private WebElement paymentConfirmation;

    @FindBy(id = "com.example.app:id/errorMessage")
    private WebElement errorMessage;

    // Page Methods
    public void enterCreditCardInformation(String cardNumber, String expiryDate, String cvv) {
        creditCardNumberField.sendKeys(cardNumber);
        expiryDateField.sendKeys(expiryDate);
        cvvField.sendKeys(cvv);
    }

    public void clickCompletePayment() {
        completePaymentButton.click();
    }

    public boolean isPaymentConfirmationDisplayed() {
        return paymentConfirmation.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
