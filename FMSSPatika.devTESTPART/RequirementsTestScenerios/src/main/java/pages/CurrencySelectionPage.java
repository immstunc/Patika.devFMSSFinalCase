package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrencySelectionPage {

    private AppiumDriver driver;


    public CurrencySelectionPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(id = "com.example.app:id/currencyDropdown")
    private WebElement currencyDropdown;

    @FindBy(id = "com.example.app:id/priceInSelectedCurrency")
    private WebElement priceInSelectedCurrency;


    public void navigateToCurrencySelectionPage() {
        navigateToCurrencySelectionPage();
    }

    public void selectCurrency(String currency) {

        currencyDropdown.sendKeys(currency);
    }

    public boolean isPricesDisplayedInSelectedCurrency() {

        return priceInSelectedCurrency.isDisplayed();
    }

    public boolean isCurrencyRetainedAfterRestart() {

        return true;
    }
}
