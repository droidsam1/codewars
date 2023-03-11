package time_formatter;

public class TimeFormatter {

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if (seconds == 1) {
            return String.format("%s second", seconds);
        }
        return String.format("%s seconds", seconds);
    }
}