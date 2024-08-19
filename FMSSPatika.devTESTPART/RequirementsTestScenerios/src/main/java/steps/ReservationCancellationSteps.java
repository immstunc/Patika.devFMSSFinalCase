package steps;

import io.appium.java_client.AppiumClientConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ReservationCancellationPage;

import static org.junit.Assert.assertTrue;

public class ReservationCancellationSteps {
    private ReservationCancellationPage reservationCancellationPage;
    private AppiumDriver driver;
    private AppiumClientConfig service;

    @Given("User opens the reservation app")
    public void userOpensReservationApp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app")
                .amend("appActivity", "com.FMSSRent2Go.appMainActivity");
        driver = new AppiumDriver(service, options);
        reservationCancellationPage = new ReservationCancellationPage(driver);
    }

    @When("User navigates to the reservation page")
    public void userNavigatesToReservationPage() {
        reservationCancellationPage.navigateToReservationPage();
    }

    @When("User selects a reservation")
    public void userSelectsReservation() {
        reservationCancellationPage.selectReservation();
    }

    @When("User cancels the reservation")
    public void userCancelsReservation() {
        reservationCancellationPage.cancelReservation();
    }

    @Then("A cancellation confirmation should be displayed")
    public void cancellationConfirmationDisplayed() {
        boolean isDisplayed = reservationCancellationPage.isCancellationConfirmed();
        assertTrue("Cancellation confirmation should be displayed", isDisplayed);
    }

    @Then("The reservation should be removed from the list")
    public void reservationShouldBeRemovedFromList() {
        boolean isRemoved = reservationCancellationPage.isReservationRemoved();
        assertTrue("Reservation should be removed from the list", isRemoved);
    }
}
