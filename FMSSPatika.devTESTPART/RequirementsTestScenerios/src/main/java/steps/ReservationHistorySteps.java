package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ReservationHistoryPage;

import static org.junit.Assert.assertTrue;

public class ReservationHistorySteps {
    private ReservationHistoryPage reservationHistoryPage;
    private AppiumDriver driver;

    @Given("User opens the app")
    public void userOpensTheApp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app")
                .amend("appActivity", "com.FMSSRent2Go.appMainActivity");
        driver = new AppiumDriver(options);
        reservationHistoryPage = new ReservationHistoryPage(driver);
    }

    @When("User navigates to the reservation history page")
    public void userNavigatesToReservationHistoryPage() {
        reservationHistoryPage.navigateToReservationHistoryPage();
    }

    @When("User selects a reservation to view")
    public void userSelectsReservationToView() {
        reservationHistoryPage.selectReservation();
    }

    @Then("User should see the reservation details")
    public void userShouldSeeReservationDetails() {
        boolean reservationVisible = reservationHistoryPage.isReservationVisible();
        assertTrue("Reservation details should be visible", reservationVisible);
    }
}
