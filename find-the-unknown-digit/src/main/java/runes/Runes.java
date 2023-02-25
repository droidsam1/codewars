package runes;

import java.util.regex.Pattern;

public class Runes {

    private static final int UNKNOWN_RUNE = -1;

    private Runes() {
    }

    public static int solveExpression(final String expression) {
        if (!expression.matches("\\d[+\\-*]\\d=[?\\d]")) {
            return UNKNOWN_RUNE;
        }

        return extractLeftOperand(expression) + extractRightOperand(expression);
    }

    private static int extractLeftOperand(String expression) {
        var pattern = Pattern.compile("(\\d)([+\\-*])");
        var matcher = pattern.matcher(expression);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return UNKNOWN_RUNE;
    }

    private static int extractRightOperand(String expression) {
        var pattern = Pattern.compile("([+\\-*])(\\d)");
        var matcher = pattern.matcher(expression);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(2));
        }

        return UNKNOWN_RUNE;
    }
}
