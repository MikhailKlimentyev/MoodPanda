package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    public static final By UPDATE_MOOD_CSS = By.cssSelector("#LinkUpdate");

    @Step("Click on update mood button")
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
