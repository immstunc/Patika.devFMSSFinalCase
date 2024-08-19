package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationHistoryPage {
    private AppiumDriver driver;

    // Constructor
    public ReservationHistoryPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/reservationHistoryList")
    private WebElement reservationHistoryList;

    @FindBy(id = "com.example.app:id/reservationDetails")
    private WebElement reservationDetails;

    // Page Methods
    public void navigateToReservationHistoryPage() {
        navigateToReservationHistoryPage();
    }

    public void selectReservation() {

    }

    public boolean isReservationVisible() {
        return reservationDetails.isDisplayed();
    }
}
