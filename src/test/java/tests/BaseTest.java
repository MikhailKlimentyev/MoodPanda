package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.PropertyReader;
import validations.MoodValidation;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {

    protected LoginPage loginPage;
    protected MoodValidation moodValidation;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        loginPage = new LoginPage();
        moodValidation = new MoodValidation();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

    protected String getEnvOrReadProperty(String key) {
        return System.getenv().getOrDefault(key, PropertyReader.getProperty(key));
    }
}
