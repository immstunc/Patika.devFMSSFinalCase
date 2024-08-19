package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private AppiumDriver driver;

    //constructor
    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/vehicleType")
    private WebElement vehicleTypeField;

    @FindBy(id = "com.example.app:id/vehicleModel")
    private WebElement vehicleModelField;

    @FindBy(id = "com.example.app:id/vehicleYear")
    private WebElement vehicleYearField;

    @FindBy(id = "com.example.app:id/vehicleTransmission")
    private WebElement vehicleTransmissionField;

    @FindBy(id = "com.example.app:id/searchButton")
    private WebElement searchButton;

    @FindBy(id = "com.example.app:id/searchResults")
    private WebElement searchResults;

    @FindBy(id = "com.example.app:id/registrationPrompt")
    private WebElement registrationPrompt;

    //Page Methods
    public void navigateToSearchPage() {
        navigateToSearchPage();
    }

    public void enterVehicleDetails(String type, String model, String year, String transmission) {
        vehicleTypeField.sendKeys(type);
        vehicleModelField.sendKeys(model);
        vehicleYearField.sendKeys(year);
        vehicleTransmissionField.sendKeys(transmission);
    }

    public void submitSearch() {
        searchButton.click();
    }

    public boolean areResultsVisible() {
        return searchResults.isDisplayed();
    }

    public boolean isRegistrationPromptVisible() {
        return registrationPrompt.isDisplayed();
    }
}
