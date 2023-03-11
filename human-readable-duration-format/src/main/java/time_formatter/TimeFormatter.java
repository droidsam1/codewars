package time_formatter;

public class TimeFormatter {

    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    private static final int SECONDS_IN_A_MINUTE = 60;

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if (seconds >= SECONDS_IN_A_MINUTE) {
            return String.format("%s %s", getMinutes(seconds), getSeconds(seconds % SECONDS_IN_A_MINUTE)).trim();
        }
        return getSeconds(seconds);
    }

    private static String getMinutes(int seconds) {
        if (seconds / SECONDS_IN_A_MINUTE == 1) {
            return String.format("%s " + MINUTE, seconds / SECONDS_IN_A_MINUTE);
        }
        if (seconds / SECONDS_IN_A_MINUTE > 1) {
            return String.format("%s " + MINUTE + "s", seconds / SECONDS_IN_A_MINUTE);
        }
        return "";
    }

    private static String getSeconds(int seconds) {
        if (seconds == 0) {
            return "";
        }

        if (seconds == 1) {
            return String.format("%s " + SECOND, seconds);
        }
        return String.format("%s " + SECOND + "s", seconds);
    }
}