package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CorporateLoginPage {

    private AppiumDriver driver;


    public CorporateLoginPage(AppiumDriver driver) {
        this.driver = driver;
    }


    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("corporate_username_field_id"));
        usernameField.sendKeys(username);
    }


    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("corporate_password_field_id"));
        passwordField.sendKeys(password);
    }


    public void submitLogin() {
        WebElement loginButton = driver.findElement(By.id("corporate_login_button_id"));
        loginButton.click();
    }


    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.id("corporate_error_message_id"));
        return errorMessage.isDisplayed();
    }


    public boolean isAccountLockedMessageDisplayed() {
        WebElement lockoutMessage = driver.findElement(By.id("corporate_lockout_message_id"));
        return lockoutMessage.isDisplayed();
    }


    public boolean isOnHomepage() {
        WebElement homepageElement = driver.findElement(By.id("corporate_homepage_element_id"));
        return homepageElement.isDisplayed();
    }
}
