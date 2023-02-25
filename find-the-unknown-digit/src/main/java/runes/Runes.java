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
        var lefOperand = matcher.group(1);
        if (lefOperand.startsWith("0") && !lefOperand.matches("0+")) {
            return UNKNOWN_RUNE;
        }

        return Integer.parseInt(lefOperand);
    }

    private static int extractRightOperand() {
        var rightOperand = matcher.group(3);
        if (rightOperand.startsWith("0") && !rightOperand.matches("0+")) {
            return UNKNOWN_RUNE;
        }
        return Integer.parseInt(rightOperand);
    }
}
