package validations;

import org.testng.Assert;

public class MoodValidation {

    public void validateMood(String actualMoodRating, String expectedMoodRating,
                             String actualDescription, String expectedDescription,
                             String actualDate, String expectedDate) {
        Assert.assertEquals(actualMoodRating, expectedMoodRating,
                String.format("Mood rating %s does not match expected %s", actualMoodRating, expectedMoodRating));
        Assert.assertEquals(actualDescription, expectedDescription,
                String.format("Description %s does not match expected %s", actualDescription, expectedDescription));
        Assert.assertTrue(actualDate.contains(expectedDate), String.format("Date %s does not contain expected %s",
                actualDate, expectedDate));
    }

    public void validateMood(String actualMoodRating, String expectedMoodRating,
                             String actualDescription, String expectedDescription) {
        Assert.assertEquals(actualMoodRating, expectedMoodRating,
                String.format("Mood rating %s does not match expected %s", actualMoodRating, expectedMoodRating));
        Assert.assertEquals(actualDescription, expectedDescription,
                String.format("Description %s does not match expected %s", actualDescription, expectedDescription));
    }
}