package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleDetailPage {
    private AppiumDriver driver;

    //Constructor
    public VehicleDetailPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Page Elements
    @FindBy(id = "com.example.app:id/vehicleDetailContainer")
    private WebElement detailPageContainer;

    @FindBy(id = "com.example.app:id/bookVehicleButton")
    private WebElement bookVehicleButton;

    @FindBy(id = "com.example.app:id/viewAdditionalPhotosButton")
    private WebElement viewAdditionalPhotosButton;

    @FindBy(id = "com.example.app:id/reviewsSection")
    private WebElement reviewsSection;

    //Page Methods
    public boolean isDetailPageVisible() {
        return detailPageContainer.isDisplayed();
    }

    public boolean isBookingOptionVisible() {
        return bookVehicleButton.isDisplayed();
    }

    public boolean isAdditionalPhotosVisible() {
        return viewAdditionalPhotosButton.isDisplayed();
    }

    public boolean isReviewsSectionVisible() {
        return reviewsSection.isDisplayed();
    }
}
