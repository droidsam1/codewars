package runes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {

    private static final int RUNE_NOT_EXISTS = -1;
    private static final String NUMBER_PATTERN = "([?\\d]+)";
    private static final Pattern pattern = Pattern.compile(NUMBER_PATTERN + "([+\\-*])" + NUMBER_PATTERN + "=" + NUMBER_PATTERN);
    private static Matcher matcher;

    private Runes() {
    }

    public static int solveExpression(final String expression) {
        matcher = pattern.matcher(expression);

        if (!matcher.matches()) {
            return RUNE_NOT_EXISTS;
        }

        var lefOperand = extractLeftOperand();
        var rightOperand = extractRightOperand();

        if (lefOperand == RUNE_NOT_EXISTS || rightOperand == RUNE_NOT_EXISTS) {
            return RUNE_NOT_EXISTS;
        }

        return lefOperand + rightOperand;
    }

    private static int extractLeftOperand() {
        var lefOperand = matcher.group(1);

        if (isNumberWithLeadingZeroes(lefOperand)) {
            return RUNE_NOT_EXISTS;
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
            return RUNE_NOT_EXISTS;
        }
        return Integer.parseInt(rightOperand);
    }
}
