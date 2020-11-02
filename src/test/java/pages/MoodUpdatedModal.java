package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModal extends BasePage {

    public static final By DONE_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Done')]");
    public static final By GO_TO_MY_DIARY_BUTTON_CSS = By.cssSelector(".ButtonMyDiary");

    @Step("Click on go to my diary button")
    public MyMoodPage clickOnGoToMyDiaryButton() {
        $(GO_TO_MY_DIARY_BUTTON_CSS).click();
        return new MyMoodPage();
    }

    @Override
    public MoodUpdatedModal isPageOpened() {
        explicitWaitElementVisible(DONE_BUTTON_XPATH);
        return this;
    }
}
