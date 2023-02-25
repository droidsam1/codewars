package runes;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum RUNE_OPERATOR {
    SUM("+", Integer::sum), PRODUCT("*", (a, b) -> a * b), SUBTRACTION("-", (a, b) -> a - b), UNKNOWN("", (a, b) -> 0);
    private final String representation;
    private final BinaryOperator<Integer> function;

    RUNE_OPERATOR(String representation, BinaryOperator<Integer> function) {
        this.representation = representation;
        this.function = function;
    }

    public static RUNE_OPERATOR from(String representation) {
        return Arrays.stream(RUNE_OPERATOR.values())
                     .filter(op -> op.getRepresentation().equals(representation))
                     .findFirst()
                     .orElse(RUNE_OPERATOR.UNKNOWN);
    }

    public String getRepresentation() {
        return representation;
    }

    public int apply(Integer a, Integer b) {
        return function.apply(a, b);
    }
}
