package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SignupSteps {
    private SignupPage signupPage;
    private AppiumDriver driver;

    @Given("User opens app")
    public void userOpensApp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appium:appPackage", "com.FMSSRent2Go.app")
                .amend("appium:appActivity", "com.FMSSRent2Go.app.MainActivity")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        signupPage = new SignupPage(driver);
    }

    @When("User navigates to the signup page")
    public void userNavigatesToSignupPage() {
        signupPage.navigateToSignupPage();
    }

    @When("User selects individual mode")
    public void userSelectsIndividualMode() {
        signupPage.selectIndividualMode();
    }

    @When("User fills in the required fields with valid data")
    public void userFillsInRequiredFieldsWithValidData() {
        signupPage.fillInSignupForm("John");
    }

    @When("User clicks the gender")
    public void userClicksTheGender() {
        signupPage.selectGender("Male"); // Example, update as needed
    }

    @When("User clicks the next button")
    public void userClicksTheNextButton() {
        signupPage.clickNextButton();
    }

    @When("User fills e mail input")
    public void userFillsEmailInput() {
        signupPage.enterEmail("john.doe@example.com");
    }

    @When("User fills phone number input")
    public void userFillsPhoneNumberInput() {
        signupPage.enterPhoneNumber("555-1234");
    }

    @When("User fills password input")
    public void userFillsPasswordInput() {
        signupPage.enterPassword("password123");
    }

    @When("User fills the confirm password input")
    public void userFillsConfirmPasswordInput() {
        signupPage.enterConfirmPassword("password123");
    }

    @When("password and confirm password inputs should be same")
    public void passwordAndConfirmPasswordInputsShouldBeSame() {
        // Implement validation if necessary
    }

    @When("User fills driver's licence ID")
    public void userFillsDriversLicenceId() {
        signupPage.enterDriversLicenceId("D1234567");
    }

    @When("User fills driving licence taking place")
    public void userFillsDrivingLicenceTakingPlace() {
        signupPage.enterDrivingLicencePlace("New York");
    }

    @When("User choose the date of taking licence")
    public void userChooseDateOfTakingLicence() {
        signupPage.selectLicenceDate("2023-01-01");
    }

    @When("User choose the licence group from the dropdown menu")
    public void userChooseLicenceGroupFromDropdown() {
        signupPage.selectLicenceGroup("Group A");
    }

    @When("User agrees to the KVKK terms")
    public void userAgreesToKVKK() {
        signupPage.agreeToKVKK();
    }

    @When("User submits the signup form")
    public void userSubmitsSignupForm() {
        signupPage.submitSignupForm();
    }

    @Then("User should receive a confirmation email")
    public void userReceivesConfirmationEmail() {
    }

    @Then("User should be redirected to the login page")
    public void userIsRedirectedToLoginPage() {
        boolean isRedirected = signupPage.isRedirectedToLoginPage();
        assertTrue("User should be redirected to the login page", isRedirected);
    }

    @When("User leaves the name field empty")
    public void userLeavesNameFieldEmpty() {
        signupPage.leaveNameFieldEmpty();
    }

    @When("User moves to the last name input field")
    public void userMovesToLastNameInputField() {
        signupPage.moveToNextField();
    }

    @Then("An alert should be displayed for the empty name field")
    public void alertShouldBeDisplayedForEmptyNameField() {
        boolean isAlertVisible = signupPage.isAlertDisplayedForEmptyField();
        assertTrue("Alert should be displayed for the empty name field", isAlertVisible);
    }

    @When("User selects corporate mode")
    public void userSelectsCorporateMode() {
        signupPage.selectCorporateMode();
    }

    @When("User navigates to the corporate signup page")
    public void userNavigatesToCorporateSignupPage() {
        signupPage.navigateToCorporateSignupPage();
    }

    @When("User fills the tax number input")
    public void userFillsTaxNumberInput() {
        signupPage.fillTaxNumberField("1234567890");
    }

    @When("User fills the company name input")
    public void userFillsCompanyNameInput() {
        signupPage.fillCompanyNameField("Example Corp.");
    }

    @When("User fills contact name input")
    public void userFillsContactNameInput() {
        signupPage.fillContactNameField("Jane Doe");
    }

    @Then("User should be redirected to the corporate login page")
    public void userShouldBeRedirectedToCorporateLoginPage() {
        boolean isOnCorporateLoginPage = signupPage.isOnCorporateLoginPage();
        assertTrue("User should be on the corporate login page", isOnCorporateLoginPage);
    }

    @When("User does not agree to the KVKK terms")
    public void userDoesNotAgreeToTerms() {
        signupPage.doNotAgreeToTerms();
    }

    @Then("An alert should be displayed indicating that accepting terms is mandatory")
    public void alertShouldBeDisplayedForMandatoryTerms() {
        boolean isAlertVisible = signupPage.isTermsMandatoryAlertDisplayed();
        assertTrue("Alert should be displayed indicating that accepting terms is mandatory", isAlertVisible);
    }


}
