package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleSearchResultsPage {
    private AppiumDriver driver;

    //Constructor
    public VehicleSearchResultsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Page Elements
    @FindBy(id = "com.example.app:id/vehicleItem")
    private WebElement vehicleItem;

    //Page Methods
    public VehicleDetailPage selectVehicle() {
        vehicleItem.click();
        return new VehicleDetailPage(driver);
    }
}
