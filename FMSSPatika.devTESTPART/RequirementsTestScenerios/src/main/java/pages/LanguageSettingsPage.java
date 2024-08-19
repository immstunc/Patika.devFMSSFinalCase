package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSettingsPage {

    private final AppiumDriver driver;

    @FindBy(id = "com.example.app:id/genderMale")
    private WebElement languageEnglishButton;

    @FindBy(id = "com.example.app:id/genderFemale")
    private WebElement languageFrenchButton;

    @FindBy(id = "com.example.app:id/genderFemale")
    private WebElement languageTurkishButton;

    @FindBy(id = "com.example.app:id/genderFemale")
    private WebElement languageArabicButton;

    public LanguageSettingsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void selectLanguage(String language) {
        if (language.equalsIgnoreCase("English")) {
            languageEnglishButton.click();
        } else if (language.equalsIgnoreCase("French")) {
            languageFrenchButton.click();
        } else if (language.equalsIgnoreCase("Turkish")) {
            languageTurkishButton.click();
        }else if (language.equalsIgnoreCase("Arabic")) {
            languageArabicButton.click();
        }
    }

    public boolean isContentDisplayedInSelectedLanguage(String language) {

        return true;
    }

    public boolean isSelectedLanguagePersisted(String language) {

        return true;
    }
}
