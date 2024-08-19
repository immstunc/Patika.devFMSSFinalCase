package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarReservationPage {

    private AppiumDriver driver;

    // Constructor
    public CarReservationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/reservationPage")
    private WebElement reservationPage;

    @FindBy(id = "com.example.app:id/carCategoryDropdown")
    private WebElement carCategoryDropdown;

    @FindBy(id = "com.example.app:id/pickupDate")
    private WebElement pickupDateField;

    @FindBy(id = "com.example.app:id/returnDate")
    private WebElement returnDateField;

    @FindBy(id = "com.example.app:id/pickupTime")
    private WebElement pickupTimeField;

    @FindBy(id = "com.example.app:id/returnTime")
    private WebElement returnTimeField;

    @FindBy(id = "com.example.app:id/paymentDetails")
    private WebElement paymentDetailsField;

    @FindBy(id = "com.example.app:id/reserveNowButton")
    private WebElement reserveNowButton;

    @FindBy(id = "com.example.app:id/reservationSuccessful")
    private WebElement reservationSuccessfulMessage;

    @FindBy(id = "com.example.app:id/reservationDetailsPage")
    private WebElement reservationDetailsPage;

    @FindBy(id = "com.example.app:id/invalidDateAlert")
    private WebElement invalidDateAlert;

    @FindBy(id = "com.example.app:id/reservationUnsuccessful")
    private WebElement reservationUnsuccessfulMessage;

    // Page Methods
    public void navigateToCarReservationPage() {
        navigateToCarReservationPage();
    }

    public void selectCarCategory(String category) {
        // Implement car category selection
    }

    public void enterPickupDate(String date) {
        pickupDateField.sendKeys(date);
    }

    public void enterReturnDate(String date) {
        returnDateField.sendKeys(date);
    }

    public void enterPickupTime(String time) {
        pickupTimeField.sendKeys(time);
    }

    public void enterReturnTime(String time) {
        returnTimeField.sendKeys(time);
    }

    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        paymentDetailsField.sendKeys(cardNumber + " " + expiryDate + " " + cvv);
    }

    public void clickReserveNowButton() {
        reserveNowButton.click();
    }

    public boolean isReservationSuccessful() {
        return reservationSuccessfulMessage.isDisplayed();
    }

    public boolean isReservationDetailsPageVisible() {
        return reservationDetailsPage.isDisplayed();
    }

    public boolean isInvalidDateAlertDisplayed() {
        return invalidDateAlert.isDisplayed();
    }

    public boolean isReservationUnsuccessful() {
        return reservationUnsuccessfulMessage.isDisplayed();
    }
}
