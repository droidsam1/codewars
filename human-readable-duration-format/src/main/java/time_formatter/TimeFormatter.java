package time_formatter;

public class TimeFormatter {

    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    private static final int SECONDS_IN_A_MINUTE = 60;
    private static final String TIME_UNIT_FORMAT = "%s %s";
    private static final String HOUR = "hour";
    private static final int SECONDS_IN_AN_HOUR = 3600;

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if (seconds >= SECONDS_IN_A_MINUTE) {
            return String.format(
                    "%s %s %s",
                    getHours(seconds),
                    getMinutes(seconds % SECONDS_IN_AN_HOUR),
                    getSeconds(seconds % SECONDS_IN_A_MINUTE)
            ).trim();
        }
        return getSeconds(seconds);
    }

    private static String getHours(int seconds) {
        return format(seconds / SECONDS_IN_AN_HOUR, HOUR);
    }

    private static String getMinutes(int seconds) {
        return format(seconds / SECONDS_IN_A_MINUTE, MINUTE);
    }

    private static String getSeconds(int seconds) {
        return format(seconds % SECONDS_IN_A_MINUTE, SECOND);
    }

    private static String format(int seconds, String unitOfTime) {
        if (seconds == 0) {
            return "";
        }

        if (seconds == 1) {
            return String.format(TIME_UNIT_FORMAT, seconds, unitOfTime);
        }
        return String.format(TIME_UNIT_FORMAT, seconds, (unitOfTime + "s"));
    }
}