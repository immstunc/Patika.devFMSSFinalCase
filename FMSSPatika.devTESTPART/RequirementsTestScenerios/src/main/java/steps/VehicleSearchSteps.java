package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VehicleSearchPage;

import static org.junit.Assert.assertTrue;

public class VehicleSearchSteps {
    private VehicleSearchPage vehicleSearchPage;
    private AppiumDriver driver;

    @Given("User opens the app")
    public void userOpensTheApp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app.")
                .amend("appActivity", "com.FMSSRent2Go.app.MainActivity");
        driver = new AppiumDriver(options);
        vehicleSearchPage = new VehicleSearchPage(driver);
    }

    @When("User navigates to the vehicle search page")
    public void userNavigatesToVehicleSearchPage() {
        vehicleSearchPage.navigateToVehicleSearchPage();
    }

    @When("User selects a vehicle category")
    public void userSelectsVehicleCategory() {
        vehicleSearchPage.selectVehicleCategory();
    }

    @When("User enters the location and date for the vehicle search")
    public void userEntersLocationAndDateForVehicleSearch() {
        vehicleSearchPage.enterSearchDetails("New York", "2024-09-01", "2024-09-10");
    }

    @When("User clicks on the search button")
    public void userClicksOnSearchButton() {
        vehicleSearchPage.clickSearchButton();
    }

    @Then("User should see a list of available vehicles")
    public void userShouldSeeListOfAvailableVehicles() {
        boolean isVehicleListVisible = vehicleSearchPage.isVehicleListVisible();
        assertTrue("List of available vehicles should be visible", isVehicleListVisible);
    }
}
