package time_formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TimeFormatter {

    private static final String TIME_UNIT_FORMAT = "%s %s";

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        if(seconds == 0){
            return "now";
        }
        var timeUnitStrings = new ArrayList<String>();
        long remainingSeconds = seconds;
        for (var timeUnit : getAllTimeUnitsSorted()) {
            timeUnitStrings.add(format(remainingSeconds / timeUnit.seconds, timeUnit.name));
            remainingSeconds = remainingSeconds % timeUnit.seconds;
        }

        return formatTime(timeUnitStrings);
    }

    private static List<TIME_UNITS> getAllTimeUnitsSorted() {
        return Arrays.stream(TIME_UNITS.values()).sorted(fromYearsToSecondsComparator()).toList();
    }

    private static Comparator<TIME_UNITS> fromYearsToSecondsComparator() {
        return Comparator.comparing((TIME_UNITS p) -> p.seconds).reversed();
    }


    private static String formatTime(List<String> timeUnits) {
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

    private static String format(long seconds, String unitOfTime) {
        if (seconds == 0) {
            return "";
        }

        if (seconds == 1) {
            return String.format(TIME_UNIT_FORMAT, seconds, unitOfTime);
        }
        return String.format(TIME_UNIT_FORMAT, seconds, (unitOfTime + "s"));
    }

    enum TIME_UNITS {
        YEAR("year", 31_536_000), DAY("day", 86400), HOUR("hour", 3600), MINUTE("minute", 60), SECONDS("second", 1);

        private final String name;
        private final long seconds;

        TIME_UNITS(String name, int seconds) {
            this.name = name;
            this.seconds = seconds;
        }
    }
}