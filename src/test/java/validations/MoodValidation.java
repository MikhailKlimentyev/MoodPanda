package validations;

import org.testng.Assert;

public class MoodValidation {

    public void validateMood(String actualMoodRating, String actualDescription,
                             String expectedMoodRating, String expectedDescription) {
        Assert.assertEquals(actualMoodRating, expectedMoodRating, "Mood rating does not match expected");
        Assert.assertEquals(actualDescription, expectedDescription, "Description does not match expected");
    }
}
