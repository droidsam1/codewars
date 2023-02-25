package runes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {

    private static final String INVALID_RUNE = "invalidRune";
    private static final String UNKNOWN_RUNE = "?";
    private static final String NUMBER_PATTERN = "([?\\d]+)";
    private static final Pattern pattern = Pattern.compile(NUMBER_PATTERN + "([+\\-*])" + NUMBER_PATTERN + "=" + NUMBER_PATTERN);
    private static Matcher matcher;

    private Runes() {
    }

    public static int solveExpression(final String expression) {
        matcher = pattern.matcher(expression);

        if (!matcher.matches()) {
            return -1;
        }

        var lefOperand = extractLeftOperand();
        var rightOperand = extractRightOperand();

        if (INVALID_RUNE.equals(lefOperand) || INVALID_RUNE.equals(rightOperand)) {
            return -1;
        }
        if (lefOperand.contains(UNKNOWN_RUNE) || rightOperand.contains(UNKNOWN_RUNE)) {
            return tryToSolveUnknownRune();
        }

        return Integer.parseInt(lefOperand) + Integer.parseInt(rightOperand);
    }

    private static String extractTotal() {
        var lefOperand = matcher.group(4);

        if (isNumberWithLeadingZeroes(lefOperand)) {
            return INVALID_RUNE;
        }

        return lefOperand;
    }

    private static String extractLeftOperand() {
        var lefOperand = matcher.group(1);

        if (isNumberWithLeadingZeroes(lefOperand)) {
            return INVALID_RUNE;
        }

        return lefOperand;
    }

    private static boolean isNumberWithLeadingZeroes(String operand) {
        return operand.startsWith("0") && !isZero(operand);
    }

    private static boolean isZero(String lefOperand) {
        return lefOperand.matches("0+");
    }

    private static String extractRightOperand() {
        var rightOperand = matcher.group(3);
        if (isNumberWithLeadingZeroes(rightOperand)) {
            return INVALID_RUNE;
        }
        return rightOperand;
    }

    private static int tryToSolveUnknownRune() {
        var lefOperand = extractLeftOperand();
        var rightOperand = extractRightOperand();
        var total = extractTotal();

        for (int i = 0; i < 10; i++) {
            var newLeft = Integer.parseInt(lefOperand.replace(UNKNOWN_RUNE, String.valueOf(i)));
            var newRight = Integer.parseInt(rightOperand.replace(UNKNOWN_RUNE, String.valueOf(i)));
            var newTotal = Integer.parseInt(total.replace(UNKNOWN_RUNE, String.valueOf(i)));
            if (newTotal == newLeft + newRight) {
                return i;
            }
        }

        return -1;
    }
}
