package pages;

import domain.Dates;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal extends BasePage {

    public static final By SLIDER_CSS = By.cssSelector(".ui-slider-handle");
    public static final By UPDATE_MOOD_BUTTON_CSS = By.cssSelector("button.ButtonUpdate");
    public static final By DESCRIPTION_TEXT_AREA_ID = By.id("TextBoxUpdateMoodTag");
    public static final By NOW_BUTTON_CSS = By.cssSelector(".ResetNow");
    public static final By YESTERDAY_BUTTON_CSS = By.cssSelector(".ResetYesterday");
    public static final By RESET_2_DAY_BUTTON_CSS = By.cssSelector(".Reset2day");
    public static final By RESET_3_DAY_BUTTON_CSS = By.cssSelector(".Reset3day");
    public static final By HOURS_SELECT_ID = By.id("ddlHistoricHour");
    public static final By MINUTES_SELECT_ID = By.id("ddlHistoricMinute");

    public MoodUpdatedModal updateMood(String moodRating, String description) {
        updateMood(moodRating);
        updateDescription(description);
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new MoodUpdatedModal();
    }

    public MoodUpdatedModal updateMood(String moodRating, String description, Dates date) {
        updateDate(date);
        return updateMood(moodRating, description);
    }

    public MoodUpdatedModal updateMood(String moodRating, String description, Dates date, String hours, String minutes) {
        updateDate(date);
        updateHours(hours);
        updateMinutes(minutes);
        return updateMood(moodRating, description);
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

    private void updateHours(String hours) {
        $(HOURS_SELECT_ID).selectOptionByValue(hours);
    }

    private void updateMinutes(String minutes) {
        $(MINUTES_SELECT_ID).selectOptionByValue(minutes);
    }

    private void updateDate(Dates date) {
        switch (date) {
            case NOW:
                $(NOW_BUTTON_CSS).click();
                break;
            case YESTERDAY:
                $(YESTERDAY_BUTTON_CSS).click();
                break;
            case DAYS_AGO_2:
                $(RESET_2_DAY_BUTTON_CSS).click();
                break;
            case DAYS_AGO_3:
                $(RESET_3_DAY_BUTTON_CSS).click();
                break;
        }
    }
}
