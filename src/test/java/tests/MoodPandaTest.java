package tests;

import domain.Dates;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MyMoodPage;

import static domain.Dates.*;

public class MoodPandaTest extends BaseTest {

    @Test(dataProvider = "datesDataProvider")
    public void moodRatingDescriptionShouldBeAsSpecifiedOnes(Dates date) {
        String expectedMoodRating = "8";
        String expectedDescription = "Description";
        MyMoodPage myMoodPage = loginPage
                .openPage()
                .login(getEnvOrReadProperty("user"), getEnvOrReadProperty("pass"))
                .isPageOpened()
                .clickOnUpdateMoodButton()
                .updateMood(expectedMoodRating, expectedDescription, date)
                .isPageOpened()
                .clickOnGoToMyDiaryButton()
                .isPageOpened();
        String actualRate = myMoodPage.getRate();
        String actualDescription = myMoodPage.getDescription();
        moodValidation
                .validateMood(actualRate, expectedMoodRating, actualDescription, expectedDescription);
    }

    @DataProvider(name = "datesDataProvider")
    public Object[][] datesDataProvider() {
        return new Object[][]{
                {NOW},
                {YESTERDAY},
                {DAYS_AGO_2},
                {DAYS_AGO_3},
        };
    }

    @Test(dataProvider = "datesHoursMinutesDataProvider")
    public void moodRatingDescriptionShouldBeAsExpectedAfterChangingHoursAndMinutes(Dates date, String hours,
                                                                                    String minutes) {
        String expectedMoodRating = "8";
        String expectedDescription = "Description";
        MyMoodPage myMoodPage = loginPage
                .openPage()
                .login(getEnvOrReadProperty("user"), getEnvOrReadProperty("pass"))
                .isPageOpened()
                .clickOnUpdateMoodButton()
                .updateMood(expectedMoodRating, expectedDescription, date, hours, minutes)
                .isPageOpened()
                .clickOnGoToMyDiaryButton()
                .isPageOpened();
        String actualRate = myMoodPage.getRate();
        String actualDescription = myMoodPage.getDescription();
        moodValidation
                .validateMood(actualRate, expectedMoodRating, actualDescription, expectedDescription);

    }

    @DataProvider(name = "datesHoursMinutesDataProvider")
    public Object[][] datesHoursMinutesDataProvider() {
        return new Object[][]{
                {YESTERDAY, "00", ":00"},
                {YESTERDAY, "04", ":45"},
                {YESTERDAY, "12", ":15"},
                {DAYS_AGO_2, "00", ":00"},
                {DAYS_AGO_2, "17", ":30"},
                {DAYS_AGO_3, "00", ":00"},
                {DAYS_AGO_3, "12", ":15"},
        };
    }

    @Test
    public void moodRatingDescriptionYearMonthDayShouldBeAsExpected() {
        String expectedMoodRating = "8";
        String expectedDescription = "Description";
        String expectedDate = "31 Oct 2019";
        MyMoodPage myMoodPage =
                loginPage
                        .openPage()
                        .login(getEnvOrReadProperty("user"), getEnvOrReadProperty("pass"))
                        .isPageOpened()
                        .clickOnUpdateMoodButton()
                        .updateMood(expectedMoodRating, expectedDescription, OLDER,
                                "9", "2019", "31",
                                "00", ":00")
                        .isPageOpened()
                        .clickOnGoToMyDiaryButton()
                        .isPageOpened();
        String actualRate = myMoodPage.getRate();
        String actualDescription = myMoodPage.getDescription();
        String actualDate = myMoodPage.getDate();
        System.out.println(actualDate);
        moodValidation
                .validateMood(actualRate, expectedMoodRating, actualDescription, expectedDescription,
                        actualDate, expectedDate);
    }
}
