package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyMoodPage extends BasePage {

    public static final By PANDA_IMAGE_CSS = By.cssSelector(".media-object");
    public static final By RATE_IMAGE_CSS = By.cssSelector(".badge.pull-right");
    public static final By DESCRIPTION_CSS = By.cssSelector(".MoodPostItem.media-content");
    public static final By DATE_CLASS = By.className("text-muteda");

    public String getRate() {
        return $(RATE_IMAGE_CSS).getText();
    }

    public String getDescription() {
        return $(DESCRIPTION_CSS).getText();
    }

    public String getDate() {
        return $(DATE_CLASS).getText();
    }

    @Override
    public MyMoodPage isPageOpened() {
        explicitWaitElementVisible(PANDA_IMAGE_CSS);
        return this;
    }
}
