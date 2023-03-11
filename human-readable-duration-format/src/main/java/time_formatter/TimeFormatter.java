package time_formatter;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        return String.format("%s second", seconds);
    }
}