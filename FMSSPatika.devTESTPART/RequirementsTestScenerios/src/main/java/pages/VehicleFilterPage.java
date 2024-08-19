package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleFilterPage {
    private AppiumDriver driver;

    //Constructor
    public VehicleFilterPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Page Elements
    @FindBy(id = "com.example.app:id/filterButton")
    private WebElement filterButton;

    @FindBy(id = "com.example.app:id/vehicleTypeDropdown")
    private WebElement vehicleTypeDropdown;

    @FindBy(id = "com.example.app:id/priceRangeDropdown")
    private WebElement priceRangeDropdown;

    @FindBy(id = "com.example.app:id/option1Checkbox")
    private WebElement option1Checkbox;

    @FindBy(id = "com.example.app:id/option2Checkbox")
    private WebElement option2Checkbox;

    @FindBy(id = "com.example.app:id/applyFiltersButton")
    private WebElement applyFiltersButton;

    @FindBy(id = "com.example.app:id/filteredList")
    private WebElement filteredList;

    //Page Methods
    public void openFilterOptions() {
        filterButton.click();
    }

    public void selectVehicleType(String vehicleType) {
        vehicleTypeDropdown.click();

    }

    public void selectPriceRange(String priceRange) {
        priceRangeDropdown.click();

    }

    public void selectAdditionalOptions(String option1, String option2) {
        option1Checkbox.click();
        option2Checkbox.click();
    }

    public void applyFilters() {
        applyFiltersButton.click();
    }

    public boolean isFilteredListVisible() {
        return filteredList.isDisplayed();
    }
}
