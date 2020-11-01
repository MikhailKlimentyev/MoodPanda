package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public static final String URL = "https://moodpanda.com/Login/";

    public static final By EMAIL_CSS = By.cssSelector("#ContentPlaceHolderContent_TextBoxEmail");
    public static final By PASS_CSS = By.cssSelector("#ContentPlaceHolderContent_TextBoxPassword");
    public static final By LOGIN_BTN_CSS = By.cssSelector("#ContentPlaceHolderContent_ButtonLogin");
    public static final By GP_ICON_CSS = By.cssSelector("[alt='MoodPanda Android App on Google Play']");

    public FeedPage login(String email, String password) {
        $(EMAIL_CSS).click();
        $(EMAIL_CSS).sendKeys(email);
        $(PASS_CSS).click();
        $(PASS_CSS).sendKeys(password);
        $(LOGIN_BTN_CSS).click();
        return new FeedPage();
    }

    public LoginPage openPage() {
        open(URL);
        return isPageOpened();
    }

    @Override
    public LoginPage isPageOpened() {
        $(GP_ICON_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }
}
