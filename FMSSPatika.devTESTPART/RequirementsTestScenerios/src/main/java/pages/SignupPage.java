package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    private AppiumDriver driver;

    // Constructor
    public SignupPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Elements
    @FindBy(id = "com.example.app:id/name")
    private WebElement nameField;

    @FindBy(id = "com.example.app:id/lastName")
    private WebElement lastNameField;

    @FindBy(id = "com.example.app:id/birthdate")
    private WebElement birthdateField;

    @FindBy(id = "com.example.app:id/nationalId")
    private WebElement nationalIdField;

    @FindBy(id = "com.example.app:id/phone")
    private WebElement phoneNumberField;

    @FindBy(id = "com.example.app:id/email")
    private WebElement emailField;

    @FindBy(id = "com.example.app:id/password")
    private WebElement passwordField;

    @FindBy(id = "com.example.app:id/passwordAgain")
    private WebElement passwordAgainField;

    @FindBy(id = "com.example.app:id/kvkkCheckbox")
    private WebElement kvkkCheckbox;

    @FindBy(id = "com.example.app:id/signupButton")
    private WebElement signupButton;

    @FindBy(id = "com.example.app:id/genderMale")
    private WebElement genderMaleButton;

    @FindBy(id = "com.example.app:id/genderFemale")
    private WebElement genderFemaleButton;

    @FindBy(id = "com.example.app:id/nextButton")
    private WebElement nextButton;

    @FindBy(id = "com.example.app:id/driversLicenceId")
    private WebElement driversLicenceIdField;

    @FindBy(id = "com.example.app:id/drivingLicencePlace")
    private WebElement drivingLicencePlaceField;

    @FindBy(id = "com.example.app:id/licenceDate")
    private WebElement licenceDateField;

    @FindBy(id = "com.example.app:id/licenceGroupDropdown")
    private WebElement licenceGroupDropdown;

    @FindBy(id = "com.example.app:id/taxNumber")
    private WebElement taxNumberField;

    @FindBy(id = "com.example.app:id/companyName")
    private WebElement companyNameField;

    @FindBy(id = "com.example.app:id/contactName")
    private WebElement contactNameField;

    @FindBy(id = "com.example.app:id/loginPage")
    private WebElement loginPage;

    @FindBy(id = "com.example.app:id/corporateLoginPage")
    private WebElement corporateLoginPage;

    @FindBy(id = "com.example.app:id/alertMessage")
    private WebElement alertMessage;

    // Page Actions
    public void navigateToSignupPage() {

    }

    public void selectIndividualMode() {

    }

    public void fillInSignupForm(String name) {
        nameField.sendKeys("name");
        lastNameField.sendKeys("lastname");
        emailField.sendKeys("email");
        nationalIdField.sendKeys("11111111111");

    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderMaleButton.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            genderFemaleButton.click();
        }
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        passwordAgainField.sendKeys(confirmPassword);
    }

    public void enterDriversLicenceId(String licenceId) {
        driversLicenceIdField.sendKeys(licenceId);
    }

    public void enterDrivingLicencePlace(String place) {
        drivingLicencePlaceField.sendKeys(place);
    }

    public void selectLicenceDate(String date) {
        licenceDateField.sendKeys(date);
    }

    public void selectLicenceGroup(String group) {
        if (group.equalsIgnoreCase("A")) {
            licenceGroupDropdown.click();
        } else if (group.equalsIgnoreCase("B")) {
            licenceGroupDropdown.click();
        } else if (group.equalsIgnoreCase("C")) {
            licenceGroupDropdown.click();
        }else if (group.equalsIgnoreCase("D")) {
            licenceGroupDropdown.click();
        }
    }

    public void agreeToKVKK() {
        kvkkCheckbox.click();
    }

    public void submitSignupForm() {
        signupButton.click();
    }

    public boolean isRedirectedToLoginPage() {
        return loginPage.isDisplayed();
    }

    public boolean isOnCorporateLoginPage() {
        return corporateLoginPage.isDisplayed();
    }

    public void leaveNameFieldEmpty() {
        nameField.clear();
    }

    public void moveToNextField() {

    }

    public boolean isAlertDisplayedForEmptyField() {
        return alertMessage.isDisplayed();
    }

    public void selectCorporateMode() {

    }

    public void navigateToCorporateSignupPage() {
        navigateToCorporateSignupPage();
    }

    public void fillTaxNumberField(String taxNumber) {
        taxNumberField.sendKeys(taxNumber);
    }

    public void fillCompanyNameField(String companyName) {
        companyNameField.sendKeys(companyName);
    }

    public void fillContactNameField(String contactName) {
        contactNameField.sendKeys(contactName);
    }

    public void doNotAgreeToTerms() {
        kvkkCheckbox.click();
    }

    public boolean isTermsMandatoryAlertDisplayed() {
        return alertMessage.isDisplayed();
    }
}
