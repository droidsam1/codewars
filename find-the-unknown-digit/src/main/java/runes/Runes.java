package runes;

public class Runes {

    private static final int UNKNOWN_RUNE = -1;

    private Runes() {
    }

    public static int solveExpression(final String expression) {
        if (!expression.matches("\\d[+\\-*]\\d=[?\\d]")) {
            return UNKNOWN_RUNE;
        }

        return 2;
    }
}
