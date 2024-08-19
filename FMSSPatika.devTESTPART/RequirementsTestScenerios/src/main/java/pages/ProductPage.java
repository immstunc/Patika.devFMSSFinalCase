package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private AppiumDriver driver;

    // Constructor
    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/productPrice")
    private WebElement productPrice;

    // Page Methods
    public void navigateToProductPage() {
        navigateToProductPage();
    }

    public boolean arePricesDisplayedInSelectedCurrency() {

        return productPrice.isDisplayed();
    }
}
