package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InvoicePage;
import pages.SignupPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class InvoiceSteps {
    private InvoicePage invoicePage;
    private AppiumDriver driver;

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

    @When("User navigates to the invoice page")
    public void userNavigatesToInvoicePage() {
        invoicePage.navigateToInvoicePage();
    }

    @When("User selects an invoice to view")
    public void userSelectsInvoiceToView() {
        invoicePage.selectInvoice();
    }

    @Then("User should see the invoice details")
    public void userShouldSeeInvoiceDetails() {
        boolean invoiceVisible = invoicePage.isInvoiceVisible();
        assertTrue("Invoice details should be visible", invoiceVisible);
    }

    @When("User chooses to download the invoice")
    public void userChoosesToDownloadInvoice() {
        invoicePage.downloadInvoice();
    }

    @Then("The invoice should be downloaded successfully")
    public void invoiceShouldBeDownloadedSuccessfully() {
        boolean downloadSuccess = invoicePage.isDownloadSuccessful();
        assertTrue("Invoice should be downloaded successfully", downloadSuccess);
    }
}
