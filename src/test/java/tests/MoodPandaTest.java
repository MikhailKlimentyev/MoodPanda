package tests;

import domain.Dates;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MyMoodPage;
import utils.UtilDate;

import static domain.Dates.*;

public class MoodPandaTest extends BaseTest {

    @Test
    public void moodRatingAndDescriptionShouldBeAsSpecifiedOnes() {
        String expectedMoodRating = "8";
        String expectedDescription = "Description";
        String expectedDate = "Just Now ·";
        MyMoodPage myMoodPage = loginPage
                .openPage()
                .login(getEnvOrReadProperty("user"), getEnvOrReadProperty("pass"))
                .isPageOpened()
                .clickOnUpdateMoodButton()
                .updateMood(expectedMoodRating, expectedDescription)
                .isPageOpened()
                .clickOnGoToMyDiaryButton()
                .isPageOpened();
        String actualRate = myMoodPage.getRate();
        String actualDescription = myMoodPage.getDescription();
        String actualDate = myMoodPage.getDate();
        moodValidation
                .validateMood(actualRate, expectedMoodRating, actualDescription, expectedDescription,
                        actualDate, expectedDate);
    }

    @Test(dataProvider = "dateExpectedDatesDataProvider")
    public void moodRatingDescriptionAndDateShouldBeAsSpecifiedOnes(Dates date, String expectedDate) {
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
        String actualDate = myMoodPage.getDate();
        moodValidation
                .validateMood(actualRate, expectedMoodRating,
                        actualDescription, expectedDescription,
                        actualDate, expectedDate);
    }

    @DataProvider(name = "dateExpectedDatesDataProvider")
    public Object[][] dateExpectedDatesDataProvider() {
        return new Object[][]{
                {NOW, "Just Now ·"},
                {YESTERDAY,
                        UtilDate.getDifferenceBetweenNowAndDateTime(YESTERDAY.getNumber(), 0, 0) + "d ·"},
                {DAYS_AGO_2,
                        UtilDate.getDifferenceBetweenNowAndDateTime(DAYS_AGO_2.getNumber(), 0, 0) + "d ·"},
                {DAYS_AGO_3,
                        UtilDate.getDifferenceBetweenNowAndDateTime(DAYS_AGO_3.getNumber(), 0, 0) + "d ·"},
        };
    }
}
