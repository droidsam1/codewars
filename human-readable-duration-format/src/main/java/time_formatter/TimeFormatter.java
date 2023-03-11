package time_formatter;

public class TimeFormatter {

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if (seconds >= 60) {
            return String.format("%s %s", getMinutes(seconds), getSeconds(seconds % 60)).trim();
        }
        return getSeconds(seconds);
    }

    private static String getMinutes(int seconds) {
        if (seconds / 60 == 1) {
            return String.format("%s minute", seconds / 60);
        }
        if (seconds / 60 > 1) {
            return String.format("%s minutes", seconds / 60);
        }
        return "";
    }

    private static String getSeconds(int seconds) {
        if (seconds == 0) {
            return "";
        }

        if (seconds == 1) {
            return String.format("%s second", seconds);
        }
        return String.format("%s seconds", seconds);
    }
}