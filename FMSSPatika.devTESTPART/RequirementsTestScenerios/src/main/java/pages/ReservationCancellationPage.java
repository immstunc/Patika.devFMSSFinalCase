package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationCancellationPage {

    private AppiumDriver driver;

    // Constructor
    public ReservationCancellationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/reservationList")
    private WebElement reservationList;

    @FindBy(id = "com.example.app:id/cancelButton")
    private WebElement cancelButton;

    @FindBy(id = "com.example.app:id/confirmationDialog")
    private WebElement confirmationDialog;

    @FindBy(id = "com.example.app:id/confirmCancel")
    private WebElement confirmCancelButton;

    @FindBy(id = "com.example.app:id/cancelledReservation")
    private WebElement cancelledReservation;

    // Page Methods
    public void navigateToReservationPage() {
        navigateToReservationPage();
    }

    public void selectReservation() {
        reservationList.click();
    }

    public void cancelReservation() {
        cancelButton.click();
        confirmCancelButton.click();
    }

    public boolean isCancellationConfirmed() {
        return confirmationDialog.isDisplayed();
    }

    public boolean isReservationRemoved() {
        return !cancelledReservation.isDisplayed();
    }
}
