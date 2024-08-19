package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VehicleFilterPage;

import static org.junit.Assert.assertTrue;

public class VehicleFilterSteps {
    private VehicleFilterPage vehicleFilterPage;
    private AppiumDriver driver;

    @Given("User is on the vehicle search results page")
    public void userIsOnVehicleSearchResultsPage() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app.")
                .amend("appActivity", "com.FMSSRent2Go.app.SearchResultsActivity");
        driver = new AppiumDriver(options);
        vehicleFilterPage = new VehicleFilterPage(driver);
    }

    @When("User opens the filter options")
    public void userOpensFilterOptions() {
        vehicleFilterPage.openFilterOptions();
    }

    @When("User selects vehicle type as {string}")
    public void userSelectsVehicleType(String vehicleType) {
        vehicleFilterPage.selectVehicleType(vehicleType);
    }

    @When("User selects price range as {string}")
    public void userSelectsPriceRange(String priceRange) {
        vehicleFilterPage.selectPriceRange(priceRange);
    }

    @When("User selects additional options like {string} and {string}")
    public void userSelectsAdditionalOptions(String option1, String option2) {
        vehicleFilterPage.selectAdditionalOptions(option1, option2);
    }

    @When("User applies the filters")
    public void userAppliesTheFilters() {
        vehicleFilterPage.applyFilters();
    }

    @Then("User should see the filtered list of vehicles")
    public void userShouldSeeFilteredListOfVehicles() {
        boolean isFilteredListVisible = vehicleFilterPage.isFilteredListVisible();
        assertTrue("Filtered list of vehicles should be visible", isFilteredListVisible);
    }
}
