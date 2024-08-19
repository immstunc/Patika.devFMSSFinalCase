package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CurrencySelectionPage;
import pages.ProductPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class StepsMultiCurrency {

    private final CurrencySelectionPage currencySelectionPage;
    private final ProductPage productPage;
    private AppiumDriver driver;

    public StepsMultiCurrency(AppiumDriver driver) {
        this.currencySelectionPage = new CurrencySelectionPage(driver);
        this.productPage = new ProductPage(driver);
    }

    @Given("User opens the app")
    public void userOpensApp() throws MalformedURLException {
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

    @Given("User is on the currency selection page")
    public void userIsOnCurrencySelectionPage() {
        currencySelectionPage.navigateToCurrencySelectionPage();
    }

    @When("User selects a currency from the dropdown")
    public void userSelectsCurrencyFromDropdown() {
        currencySelectionPage.selectCurrency("USD");
    }

    @Then("Application should display prices in the selected currency")
    public void applicationDisplaysPricesInSelectedCurrency() {
        assertTrue("Prices are displayed in the selected currency", currencySelectionPage.isPricesDisplayedInSelectedCurrency());
    }

    @Given("User has selected a different currency")
    public void userHasSelectedDifferentCurrency() {
        currencySelectionPage.selectCurrency("EUR");
    }

    @When("User navigates to the product page")
    public void userNavigatesToProductPage() {
        productPage.navigateToProductPage();
    }

    @Then("Product prices should be displayed in the selected currency")
    public void productPricesDisplayedInSelectedCurrency() {
        assertTrue("Product prices are displayed in the selected currency", productPage.arePricesDisplayedInSelectedCurrency());
    }

    @When("User closes and reopens the app")
    public void userClosesAndReopensApp() {
        driver.quit();
        try {
            userOpensApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Then("Application should retain the selected currency after app restart")
    public void applicationRetainsSelectedCurrency() {
        assertTrue("Selected currency is retained after app restart", currencySelectionPage.isCurrencyRetainedAfterRestart());
    }
}
