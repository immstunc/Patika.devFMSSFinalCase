package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
    private AppiumDriver driver;

    public InvoicePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.example.app:id/invoiceList")
    private WebElement invoiceList;

    @FindBy(id = "com.example.app:id/invoiceDetails")
    private WebElement invoiceDetails;

    @FindBy(id = "com.example.app:id/downloadButton")
    private WebElement downloadButton;

    @FindBy(id = "com.example.app:id/downloadSuccessMessage")
    private WebElement downloadSuccessMessage;

    public void navigateToInvoicePage() {

    }

    public void selectInvoice() {

    }

    public boolean isInvoiceVisible() {
        return invoiceDetails.isDisplayed();
    }

    public void downloadInvoice() {
        downloadButton.click();
    }

    public boolean isDownloadSuccessful() {
        return downloadSuccessMessage.isDisplayed();
    }
}
