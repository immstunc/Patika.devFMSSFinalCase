package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final AppiumDriver driver = null;

    public LoginPage() {

    }

    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username_field_id"));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password_field_id"));
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        WebElement loginButton = driver.findElement(By.id("login_button_id"));
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.id("error_message_id"));
        return errorMessage.isDisplayed();
    }

    public boolean isAccountLockedMessageDisplayed() {
        WebElement lockoutMessage = driver.findElement(By.id("lockout_message_id"));
        return lockoutMessage.isDisplayed();
    }

    public boolean isOnHomepage() {
        WebElement homepageElement = driver.findElement(By.id("homepage_element_id"));
        return homepageElement.isDisplayed();
    }
}
