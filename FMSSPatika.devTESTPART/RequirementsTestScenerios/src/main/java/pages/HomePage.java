package pages;

import io.appium.java_client.AppiumDriver;

public class HomePage {

    private final AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void launchApp() {

    }

    public boolean isContentDisplayedInDefaultLanguage() {

        return true;
    }

    public void ensureHomePageIsVisible() {

    }

    public void navigateToSettingsPage() {

    }

    public void navigateToProfilePage() {

    }

    public void navigateToHelpPage() {

    }

    public boolean isContentDisplayedInSelectedLanguageAcrossScreens(String language) {

        return true;
    }
}
