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

        var lefOperand = extractLeftOperand();
        var rightOperand = extractRightOperand();

        if (lefOperand == UNKNOWN_RUNE || rightOperand == UNKNOWN_RUNE) {
            return UNKNOWN_RUNE;
        }

        return lefOperand + rightOperand;
    }

    private static int extractLeftOperand() {
        var lefOperand = matcher.group(1);

        if (isNumberWithLeadingZeroes(lefOperand)) {
            return UNKNOWN_RUNE;
        }

        return Integer.parseInt(lefOperand);
    }

    private static boolean isNumberWithLeadingZeroes(String operand) {
        return operand.startsWith("0") && !isZero(operand);
    }

    private static boolean isZero(String lefOperand) {
        return lefOperand.matches("0+");
    }

    private static int extractRightOperand() {
        var rightOperand = matcher.group(3);
        if (isNumberWithLeadingZeroes(rightOperand)) {
            return UNKNOWN_RUNE;
        }
        return Integer.parseInt(rightOperand);
    }
}
