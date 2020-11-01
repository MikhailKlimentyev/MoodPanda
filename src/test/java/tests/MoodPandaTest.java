package tests;

import org.testng.annotations.Test;
import pages.MyMoodPage;

public class MoodPandaTest extends BaseTest {

    @Test
    public void moodRatingAndDescriptionShouldBeAsSpecifiedOnes() {
        String expectedMoodRating = "8";
        String expectedDescription = "Description";
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
        moodValidation
                .validateMood(actualRate, actualDescription, expectedMoodRating, expectedDescription);
    }
}
