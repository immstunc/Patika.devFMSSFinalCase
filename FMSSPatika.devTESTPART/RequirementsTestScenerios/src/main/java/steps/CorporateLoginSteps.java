package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CorporateLoginPage;
import pages.VehicleSearchResultsPage;

public class CorporateLoginSteps {

    private AppiumDriver driver;
    private CorporateLoginPage corporateLoginPage;


    public CorporateLoginSteps(AppiumDriver driver) {
        this.driver = driver;
        corporateLoginPage = new CorporateLoginPage(driver);
    }
    @Given("User is on the vehicle search results page")
    public void userIsOnVehicleSearchResultsPage() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "emulator-5554")
                .amend("appPackage", "com.example.app")
                .amend("appActivity", "com.example.app.SearchResultsActivity");
        driver = new AppiumDriver(options);
    }

    @When("User enters a valid corporate username")
    public void userEntersCorporateUsername() {
        corporateLoginPage.enterUsername("corporateUser");
    }

    @When("User enters a valid corporate password")
    public void userEntersCorporatePassword() {
        corporateLoginPage.enterPassword("corporatePassword123");
    }

    @When("User clicks on the {string} button")
    public void userClicksLoginButton(String button) {
        if (button.equalsIgnoreCase("Login")) {
            corporateLoginPage.submitLogin();
        }
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedIn() {
        assert corporateLoginPage.isOnHomepage() : "User failed to log in!";
    }

    @Then("An error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assert corporateLoginPage.isErrorMessageDisplayed() : "Error message not displayed!";
    }

    @Then("An account locked message should be displayed")
    public void accountLockedMessageShouldBeDisplayed() {
        assert corporateLoginPage.isAccountLockedMessageDisplayed() : "Account locked message not displayed!";
    }
}
