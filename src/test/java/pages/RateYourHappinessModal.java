package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal extends BasePage {

    public static final By SLIDER_CSS = By.cssSelector(".ui-slider-handle");
    public static final By UPDATE_MOOD_BUTTON_CSS = By.cssSelector("button.ButtonUpdate");
    public static final By DESCRIPTION_TEXT_AREA_ID = By.id("TextBoxUpdateMoodTag");

    public MoodUpdatedModal updateMood(String moodRating, String description) {
        updateMood(moodRating);
        updateDescription(description);
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new MoodUpdatedModal();
    }

    @Override
    public RateYourHappinessModal isPageOpened() {
        explicitWaitElementVisible(UPDATE_MOOD_BUTTON_CSS);
        return this;
    }

    private void updateMood(String moodRating) {
        int moodRatingNumber = Integer.parseInt(moodRating);
        int defaultMoodNumber = 5;
        $(SLIDER_CSS).click();
        Keys direction;
        if (moodRatingNumber > defaultMoodNumber) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodRatingNumber - defaultMoodNumber); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
    }

    private void updateDescription(String description) {
        $(DESCRIPTION_TEXT_AREA_ID).sendKeys(description);
    }
}
