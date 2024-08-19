package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleSearchPage {
    private AppiumDriver driver;

    //Constructor
    public VehicleSearchPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Page elements
    @FindBy(id = "com.example.app:id/vehicleCategoryDropdown")
    private WebElement vehicleCategoryDropdown;

    @FindBy(id = "com.example.app:id/locationInput")
    private WebElement locationInput;

    @FindBy(id = "com.example.app:id/startDateInput")
    private WebElement startDateInput;

    @FindBy(id = "com.example.app:id/endDateInput")
    private WebElement endDateInput;

    @FindBy(id = "com.example.app:id/searchButton")
    private WebElement searchButton;

    @FindBy(id = "com.example.app:id/vehicleList")
    private WebElement vehicleList;

    //Page Methods
    public void navigateToVehicleSearchPage() {
       navigateToVehicleSearchPage();
    }

    public void selectVehicleCategory() {

        vehicleCategoryDropdown.click();

    }

    public void enterSearchDetails(String location, String startDate, String endDate) {
        locationInput.sendKeys(location);
        startDateInput.sendKeys(startDate);
        endDateInput.sendKeys(endDate);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isVehicleListVisible() {
        return vehicleList.isDisplayed();
    }
}
