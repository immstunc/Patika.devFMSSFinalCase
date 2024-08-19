package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LanguageSettingsPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class StepsMultiLanguage {

    private final HomePage homePage;
    private final LanguageSettingsPage languageSettingsPage;
    private AppiumDriver driver;

    public StepsMultiLanguage(AppiumDriver driver) {
        this.homePage = new HomePage(driver);
        this.languageSettingsPage = new LanguageSettingsPage(driver);
    }

    @Given("the app is installed on the device")
    public void theAppIsInstalledOnTheDevice() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel 6")
                .amend("automationName", "UiAutomator2")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:app", "/merve/Rent2Go/app.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @When("the user opens the app")
    public void theUserOpensTheApp() {
        homePage.launchApp();
    }

    @Then("the app should display the content in the default language")
    public void theAppShouldDisplayContentInDefaultLanguage() {
        assertTrue("App displays content in default language", homePage.isContentDisplayedInDefaultLanguage());
    }

    @Given("the user is on the home screen")
    public void theUserIsOnTheHomeScreen() {
        homePage.ensureHomePageIsVisible();
    }

    @When("the user navigates to the settings page")
    public void theUserNavigatesToSettingsPage() {
        homePage.navigateToSettingsPage();
    }

    @When("the user selects French from the language options")
    public void theUserSelectsFrenchFromLanguageOptions() {
        languageSettingsPage.selectLanguage("French");
    }

    @Then("the app should display the content in French")
    public void theAppShouldDisplayContentInFrench() {
        assertTrue("App displays content in French", languageSettingsPage.isContentDisplayedInSelectedLanguage("French"));
    }

    @Then("the selected language should persist across app restarts")
    public void theSelectedLanguageShouldPersistAcrossAppRestarts() {
        driver.quit();
        try {
            theAppIsInstalledOnTheDevice(); // Reopen the app
            assertTrue("Selected language persists after app restart", languageSettingsPage.isSelectedLanguagePersisted("French"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Given("the app is running in a specific language")
    public void theAppIsRunningInASpecificLanguage() {
        languageSettingsPage.selectLanguage("Spanish");
        assertTrue("App is running in the specific language", languageSettingsPage.isContentDisplayedInSelectedLanguage("Spanish"));
    }

    @When("the user navigates through various screens like profile, settings, and help")
    public void theUserNavigatesThroughVariousScreens() {
        homePage.navigateToProfilePage();
        homePage.navigateToHelpPage();
        homePage.navigateToSettingsPage();
    }

    @Then("the app should consistently display all content in the selected language")
    public void theAppShouldConsistentlyDisplayAllContentInSelectedLanguage() {
        assertTrue("All screens display content in the selected language", homePage.isContentDisplayedInSelectedLanguageAcrossScreens("Spanish"));
    }
}
