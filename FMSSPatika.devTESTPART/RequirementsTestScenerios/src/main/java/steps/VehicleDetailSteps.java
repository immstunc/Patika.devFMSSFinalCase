package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VehicleDetailPage;
import pages.VehicleSearchResultsPage;

import static org.junit.Assert.assertTrue;

public class VehicleDetailSteps {
    private AppiumDriver driver;
    private VehicleSearchResultsPage vehicleSearchResultsPage;
    private VehicleDetailPage vehicleDetailPage;

    @Given("User is on the vehicle search results page")
    public void userIsOnVehicleSearchResultsPage() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app.")
                .amend("appActivity", "com.FMSSRent2Go.app.SearchResultsActivity");
        driver = new AppiumDriver(options);
        vehicleSearchResultsPage = new VehicleSearchResultsPage(driver);
    }

    @When("User selects a vehicle from the list")
    public void userSelectsVehicleFromList() {
        vehicleDetailPage = vehicleSearchResultsPage.selectVehicle();
    }

    @Then("User should see the vehicle detail page with all relevant information")
    public void userShouldSeeVehicleDetailPage() {
        boolean isDetailPageVisible = vehicleDetailPage.isDetailPageVisible();
        assertTrue("Vehicle detail page should be visible", isDetailPageVisible);
    }

    @Then("User should see options to book the vehicle, view additional photos, and read reviews")
    public void userShouldSeeOptions() {
        assertTrue("Booking option should be visible", vehicleDetailPage.isBookingOptionVisible());
        assertTrue("Additional photos option should be visible", vehicleDetailPage.isAdditionalPhotosVisible());
        assertTrue("Reviews section should be visible", vehicleDetailPage.isReviewsSectionVisible());
    }
}
