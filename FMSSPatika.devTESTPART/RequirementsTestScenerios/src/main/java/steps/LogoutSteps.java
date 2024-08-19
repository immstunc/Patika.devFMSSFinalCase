package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;

public class LogoutSteps {

    private AppiumDriver driver;
    private LogoutPage logoutPage;


    public LogoutSteps(AppiumDriver driver) {
        this.driver = driver;
        logoutPage = new LogoutPage(driver);
    }

    @Given("User is logged in as an individual customer")
    public void userIsLoggedInAsAnIndividualCustomer() {
    }

    @When("User navigates to the profile screen using the bottom navbar")
    public void userNavigatesToProfileScreen() throws InterruptedException {
        logoutPage.navigateToProfile();
    }

    @When("User clicks on the {string} button")
    public void userClicksLogoutButton(String button) throws InterruptedException {
        if (button.equalsIgnoreCase("Logout")) {
            logoutPage.clickLogoutButton();
        }
    }

    @Then("User should be logged out")
    public void userShouldBeLoggedOut() throws InterruptedException {
        logoutPage.confirmLogout();
    }

    @Then("User should be redirected to the login screen")
    public void userRedirectedToLoginScreen() {
        assert logoutPage.isLoggedOut() : "User is not logged out!";
    }



    @When("User clicks the back button on the device")
    public void userClicksBackButton() {
        driver.navigate().back();
    }

    @Then("User should stay on the login screen")
    public void userStaysOnLoginScreen() {

        assert logoutPage.isLoggedOut() : "User should stay on login screen!";
    }

    @Then("User should not be able to return to the profile screen")
    public void userCannotReturnToProfileScreen() {

        assert logoutPage.isLoggedOut() : "User should not return to profile screen!";
    }


}
