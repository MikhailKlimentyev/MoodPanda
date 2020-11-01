package validations;

import org.testng.Assert;

public class MoodValidation {

    public void validateMood(String actualMoodRating, String expectedMoodRating,
                             String actualDescription, String expectedDescription,
                             String actualDate, String expectedDate) {
        Assert.assertEquals(actualMoodRating, expectedMoodRating, "Mood rating does not match expected");
        Assert.assertEquals(actualDescription, expectedDescription, "Description does not match expected");
        Assert.assertEquals(actualDate, expectedDate, "Date does not match expected");
    }
}
