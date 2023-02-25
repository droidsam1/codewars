package runes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {

    private static final int UNKNOWN_RUNE = -1;
    private static final Pattern pattern = Pattern.compile("(\\d+)([+\\-*])(\\d+)=([?\\d])");
    private static Matcher matcher;


    private Runes() {
    }

    public static int solveExpression(final String expression) {
        matcher = pattern.matcher(expression);

        if (!matcher.matches()) {
            return UNKNOWN_RUNE;
        }

        return extractLeftOperand() + extractRightOperand();
    }

    private static int extractLeftOperand() {
        return Integer.parseInt(matcher.group(1));
    }

    private static int extractRightOperand() {
        return Integer.parseInt(matcher.group(3));
    }
}
