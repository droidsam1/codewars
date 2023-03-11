package time_formatter;

public class TimeFormatter {

    private TimeFormatter(){}

    public static String formatDuration(int seconds) {
        return String.format("%s second", seconds);
    }
}