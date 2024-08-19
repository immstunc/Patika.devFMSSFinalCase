package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage;
    private AppiumDriver driver;

    public LoginSteps(AppiumDriver driver) {
        this.loginPage = new LoginPage();
    }

    @Given("User opens app")
    public void userOpensApp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appium:appPackage", "com.FMSSRent2Go.app")
                .amend("appium:appActivity", "com.FMSSRent2Go.appMainActivity")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @When("User navigates to the login page")
    public void userNavigatesToTheLoginPage() {

    }

    @When("User enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
    }

    @When("User enters invalid username and password")
    public void userEntersInvalidCredentials() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("invalidPassword");
    }

    @When("User leaves the username or password field empty")
    public void userLeavesFieldsEmpty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("User submits the login form")
    public void userSubmitsLoginForm() {
        loginPage.submitLogin();
    }

    @When("User enters invalid credentials multiple times")
    public void userEntersInvalidCredentialsMultipleTimes() {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername("invalidUsername");
            loginPage.enterPassword("invalidPassword");
            loginPage.submitLogin();
        }
    }

    @Then("User should be redirected to the homepage")
    public void userShouldBeRedirectedToHomepage() {
        assertTrue("User should be redirected to the homepage", loginPage.isOnHomepage());
    }

    @Then("An error message should be displayed indicating invalid credentials")
    public void errorMessageShouldBeDisplayed() {
        assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
    }

    @Then("An error message should be displayed indicating that all fields are required")
    public void errorMessageForEmptyFieldsShouldBeDisplayed() {
        assertTrue("Error message for empty fields should be displayed", loginPage.isErrorMessageDisplayed());
    }

    @Then("User account should be locked and a lockout message displayed")
    public void accountShouldBeLocked() {
        assertTrue("Account should be locked and a lockout message displayed", loginPage.isAccountLockedMessageDisplayed());
    }
}
