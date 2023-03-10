package runes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Runes {

    private static final String INVALID_RUNE = "invalidRune";
    private static final String UNKNOWN_RUNE = "?";
    private static final String NUMBER_PATTERN = "(-?[?\\d]+)";
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
        var operator = extractOperator();

        if (INVALID_RUNE.equals(lefOperand) || INVALID_RUNE.equals(rightOperand) || RUNE_OPERATOR.UNKNOWN.equals(
                operator)) {
            return -1;
        }
        return tryToSolveUnknownRune();
    }

    private static RUNE_OPERATOR extractOperator() {
        var operator = matcher.group(2);
        return RUNE_OPERATOR.from(operator);
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

    private static boolean isNumberWithLeadingZeroes(String... operand) {
        return Arrays.stream(operand).anyMatch(op -> startWithZero(op) && !isZero(op));
    }

    private static boolean isNumberAlreadyPresentInExpression(int i) {
        var lefOperand = extractLeftOperand();
        var rightOperand = extractRightOperand();
        var total = extractTotal();

        return Stream.of(lefOperand, rightOperand, total).anyMatch(op -> op.contains(String.valueOf(i)));
    }

    private static boolean startWithZero(String operand) {
        return operand.matches("^(-?0).*");
    }

    private static boolean isZero(String operand) {
        return operand.matches("0");
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
        var operator = extractOperator();
        var total = extractTotal();

        for (int i = 0; i < 10; i++) {
            var newLeft = lefOperand.replace(UNKNOWN_RUNE, String.valueOf(i));
            var newRight = rightOperand.replace(UNKNOWN_RUNE, String.valueOf(i));
            var newTotal = total.replace(UNKNOWN_RUNE, String.valueOf(i));

            if (isNumberWithLeadingZeroes(newLeft, newRight, newTotal) || isNumberAlreadyPresentInExpression(i)) {
                continue;
            }
            if (Integer.parseInt(newTotal) == operator.apply(Integer.parseInt(newLeft), Integer.parseInt(newRight))) {
                return i;
            }
        }

        return -1;
    }
}
