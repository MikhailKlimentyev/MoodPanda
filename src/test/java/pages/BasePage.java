package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    protected abstract BasePage isPageOpened();

    protected void explicitWaitElementVisible(By locator) {
        $(locator).waitUntil(Condition.visible, 10000);
    }
}
