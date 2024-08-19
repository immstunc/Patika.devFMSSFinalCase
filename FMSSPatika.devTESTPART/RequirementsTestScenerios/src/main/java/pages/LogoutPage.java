package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPage {

    private AppiumDriver driver;

    public LogoutPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void navigateToProfile() throws InterruptedException {
        WebElement profileIcon = driver.findElement(By.id("com.example.app:id/profile_icon"));
        profileIcon.click();
    }

    public void clickLogoutButton() throws InterruptedException {
        WebElement logoutButton = driver.findElement(By.id("com.example.app:id/logout_button"));
        logoutButton.click();
    }

    public void confirmLogout() throws InterruptedException {
        WebElement confirmLogoutButton = driver.findElement(By.id("com.example.app:id/confirm_logout_button"));
        confirmLogoutButton.click();
    }

    public boolean isLoggedOut() {

        try {
            driver.findElement(By.id("com.example.app:id/profile_icon"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isOnLoginScreen() {

        try {
            driver.findElement(By.id("com.example.app:id/logout_button"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
