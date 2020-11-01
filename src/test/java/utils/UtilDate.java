package utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class UtilDate {

    public static int getDifferenceBetweenNowAndDateTime(int days, int hours, int minutes) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime setDateTime = now.minusDays(days).withHour(hours).withMinute(minutes);
        long hoursDifference = Duration.between(setDateTime, now).toHours();
        int roundedResult = (int) Math.round((double) hoursDifference / 24);
        return roundedResult;
    }
}
