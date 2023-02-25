import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import runes.Runes;
import org.junit.jupiter.api.Test;

class RunesTest {


    @Test void shouldReturnMinusOneForUnknownRune() {
        var input = "A";

        var sum = Runes.solveExpression(input);

        assertEquals(-1, sum);
    }

    @Test void shouldSumTwoNumbers() {
        var input = "1+1=?";

        var sum = Runes.solveExpression(input);

        assertEquals(2, sum);

    }


    @Disabled @Test void testSample() {
        assertEquals(2, Runes.solveExpression("1+1=?"), "Answer for expression '1+1=?' ");
        assertEquals(6, Runes.solveExpression("123*45?=5?088"), "Answer for expression '123*45?=5?088' ");
        assertEquals(0, Runes.solveExpression("-5?*-1=5?"), "Answer for expression '-5?*-1=5?' ");
        assertEquals(-1, Runes.solveExpression("19--45=5?"), "Answer for expression '19--45=5?' ");
        assertEquals(5, Runes.solveExpression("??*??=302?"), "Answer for expression '??*??=302?' ");
        assertEquals(2, Runes.solveExpression("?*11=??"), "Answer for expression '?*11=??' ");
        assertEquals(2, Runes.solveExpression("??*1=??"), "Answer for expression '??*1=??' ");
        assertEquals(-1, Runes.solveExpression("??+??=??"), "Answer for expression '??+??=??' ");
    }

}