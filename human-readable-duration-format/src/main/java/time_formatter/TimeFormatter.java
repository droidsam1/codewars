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

        var hours = getHours(seconds);
        var minutes = getMinutes(seconds % SECONDS_IN_AN_HOUR);
        var remainingSeconds = getSeconds(seconds % SECONDS_IN_A_MINUTE);

        StringBuilder formattedString = new StringBuilder();

        if (!hours.isEmpty()) {
            formattedString.append(hours);
        }

        if (!minutes.isEmpty()) {
            if (formattedString.length() != 0) {
                formattedString.append(", ");
            }
            formattedString.append(minutes);
        }

        if (!remainingSeconds.isEmpty()) {
            if (formattedString.length() != 0) {
                formattedString.append(" and ");
            }
            formattedString.append(remainingSeconds);
        }

        return formattedString.toString();
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