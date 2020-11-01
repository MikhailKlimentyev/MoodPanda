package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyMoodPage extends BasePage {

    public static final By PANDA_IMAGE_CSS = By.cssSelector(".media-object");
    public static final By RATE_IMAGE_CSS = By.cssSelector(".badge.pull-right");
    public static final By DESCRIPTION_CSS = By.cssSelector(".MoodPostItem.media-content");

    public String getRate() {
        return $(RATE_IMAGE_CSS).getText();
    }

    public String getDescription() {
        return $(DESCRIPTION_CSS).getText();
    }

    @Override
    public MyMoodPage isPageOpened() {
        $(PANDA_IMAGE_CSS).click();
        return this;
    }
}
