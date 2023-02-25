package runes;

import java.util.Arrays;
import java.util.function.BinaryOperator;
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
        var operator = extractOperator();

        if (INVALID_RUNE.equals(lefOperand) || INVALID_RUNE.equals(rightOperand) || OPERATOR.UNKNOWN.equals(operator)) {
            return -1;
        }
        if (lefOperand.contains(UNKNOWN_RUNE) || rightOperand.contains(UNKNOWN_RUNE)) {
            return tryToSolveUnknownRune();
        }

        return operator.apply(Integer.parseInt(lefOperand), Integer.parseInt(rightOperand));
    }

    private static OPERATOR extractOperator() {
        var operator = matcher.group(2);
        return OPERATOR.from(operator);
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
        return Arrays.stream(operand).anyMatch(op -> op.startsWith("0") && !isZero(op));
    }

    private static boolean isZero(String lefOperand) {
        return lefOperand.matches("0");
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

            if (isNumberWithLeadingZeroes(newLeft, newRight, newTotal)) {
                continue;
            }
            if (Integer.parseInt(newTotal) == operator.apply(Integer.parseInt(newLeft), Integer.parseInt(newRight))) {
                return i;
            }
        }

        return -1;
    }

    private enum OPERATOR {
        SUM("+", Integer::sum), PRODUCT("*", (a, b) -> a * b), UNKNOWN("", (a, b) -> 0);
        private final String representation;
        private final BinaryOperator<Integer> function;

        OPERATOR(String representation, BinaryOperator<Integer> function) {
            this.representation = representation;
            this.function = function;
        }

        public static OPERATOR from(String representation) {
            return Arrays.stream(OPERATOR.values())
                         .filter(op -> op.getRepresentation().equals(representation))
                         .findFirst()
                         .orElse(OPERATOR.UNKNOWN);
        }

        public String getRepresentation() {
            return representation;
        }

        public int apply(Integer a, Integer b) {
            return function.apply(a, b);
        }

    }
}
