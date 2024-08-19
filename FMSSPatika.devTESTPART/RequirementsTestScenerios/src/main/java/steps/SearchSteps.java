package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchSteps {
    private SearchPage searchPage;
    private AppiumDriver driver;

    @Given("User opens the app")
    public void userOpensTheApp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("deviceName", "Pixel_6")
                .amend("appPackage", "com.FMSSRent2Go.app")
                .amend("appActivity", "com.FMSSRent2Go.appMainActivity");
        driver = new AppiumDriver(options);
        searchPage = new SearchPage(driver);
    }

    @When("User navigates to the search page")
    public void userNavigatesToSearchPage() {
        searchPage.navigateToSearchPage();
    }

    @When("User enters the vehicle details")
    public void userEntersVehicleDetails() {
        searchPage.enterVehicleDetails("Car", "Sedan", "2023", "Automatic");
    }

    @When("User submits the search")
    public void userSubmitsSearch() {
        searchPage.submitSearch();
    }

    @Then("User should see the search results")
    public void userShouldSeeSearchResults() {
        boolean resultsVisible = searchPage.areResultsVisible();
        assertTrue("Search results should be visible", resultsVisible);
    }

    @Then("User should not be prompted to register")
    public void userShouldNotBePromptedToRegister() {
        boolean registrationPrompt = searchPage.isRegistrationPromptVisible();
        assertFalse("User should not be prompted to register", registrationPrompt);
    }
}
