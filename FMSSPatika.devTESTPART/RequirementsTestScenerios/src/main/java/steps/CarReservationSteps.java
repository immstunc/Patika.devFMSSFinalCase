package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarReservationPage;
import pages.LoginPage;
import pages.SignupPage;
import pages.VehicleSearchResultsPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class CarReservationSteps {

    private final LoginPage loginPage;
    private final CarReservationPage carReservationPage;
    private AppiumDriver driver;

    public CarReservationSteps(AppiumDriver driver) {
        this.loginPage = new LoginPage();
        this.carReservationPage = new CarReservationPage(driver);
    }

    @Given("User opens app")
    public void userOpensApp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appium:appPackage", "com.example.app")
                .amend("appium:appActivity", "com.example.app.MainActivity")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

    }


    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.submitLogin();
    }

    @When("User navigates to the car reservation page")
    public void userNavigatesToCarReservationPage() {
        carReservationPage.navigateToCarReservationPage();
    }

    @When("User selects a car category")
    public void userSelectsCarCategory() {
        carReservationPage.selectCarCategory("SUV"); // Adjust the category as needed
    }

    @When("User enters the date and time for pickup and return")
    public void userEntersDateAndTime() {
        carReservationPage.enterPickupDate("2024-08-20");
        carReservationPage.enterReturnDate("2024-08-25");
        carReservationPage.enterPickupTime("10:00 AM");
        carReservationPage.enterReturnTime("10:00 AM");
    }

    @When("User enters valid payment details")
    public void userEntersValidPaymentDetails() {
        carReservationPage.enterPaymentDetails("4111111111111111", "12/24", "123"); // Example credit card details
    }

    @When("User clicks on \"Reserve Now\" button")
    public void userClicksReserveNowButton() {
        carReservationPage.clickReserveNowButton();
    }

    @Then("Reservation should be successful")
    public void reservationShouldBeSuccessful() {
        assertTrue("Reservation should be successful", carReservationPage.isReservationSuccessful());
    }

    @Then("User should see the reservation details page")
    public void userShouldSeeReservationDetailsPage() {
        assertTrue("Reservation details page should be visible", carReservationPage.isReservationDetailsPageVisible());
    }

    @When("User selects a past date or invalid date")
    public void userSelectsInvalidDate() {
        carReservationPage.enterPickupDate("2024-08-10"); // Past date example
    }

    @Then("An \"Invalid date\" alert should be displayed")
    public void invalidDateAlertShouldBeDisplayed() {
        assertTrue("Invalid date alert should be displayed", carReservationPage.isInvalidDateAlertDisplayed());
    }

    @Then("Reservation should not be successful")
    public void reservationShouldNotBeSuccessful() {
        assertTrue("Reservation should not be successful", carReservationPage.isReservationUnsuccessful());
    }
}
