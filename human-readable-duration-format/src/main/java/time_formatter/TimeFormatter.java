package time_formatter;

public class TimeFormatter {

    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    private static final int SECONDS_IN_A_MINUTE = 60;
    private static final String TIME_UNIT_FORMAT = "%s %s";
    private static final String HOUR = "hour";
    private static final int SECONDS_IN_AN_HOUR = 3600;
    private static final int SECONDS_IN_ONE_DAY = 86400;
    private static final String DAY = "day";

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {

        var days = getDays(seconds);
        var hours = getHours(seconds % SECONDS_IN_ONE_DAY);
        var minutes = getMinutes(seconds % SECONDS_IN_AN_HOUR);
        var remainingSeconds = getSeconds(seconds % SECONDS_IN_A_MINUTE);

        return formatTime(days, hours, minutes, remainingSeconds);
    }

    private static String formatTime(String... timeUnits) {
        var formattedString = new StringBuilder();
        for (var timeUnit : timeUnits) {
            if (!timeUnit.isEmpty()) {
                if (formattedString.length() != 0) {
                    formattedString.append(", ");
                }
                formattedString.append(timeUnit);
            }
        }

        if (formattedString.indexOf(", ") > 0) {
            formattedString.replace(formattedString.lastIndexOf(", "), formattedString.lastIndexOf(", ") + 2, " and ");
        }

        return formattedString.toString();
    }

    private static String getDays(int seconds) {
        return format(seconds / SECONDS_IN_ONE_DAY, DAY);
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