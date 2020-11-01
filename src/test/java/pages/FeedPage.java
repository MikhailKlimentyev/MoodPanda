package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    public static final By UPDATE_MOOD_CSS = By.cssSelector("#LinkUpdate");

    public RateYourHappinessModal clickOnUpdateMoodButton() {
        $(UPDATE_MOOD_CSS).click();
        return new RateYourHappinessModal();
    }

    @Override
    public FeedPage isPageOpened() {
        explicitWaitElementVisible(UPDATE_MOOD_CSS);
        return this;
    }
}
