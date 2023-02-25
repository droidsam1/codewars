import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import runes.Runes;
import org.junit.jupiter.api.Test;

class RunesTest {

    public static Stream<Arguments> sumOfTwoNumbers() {
        return Stream.of(
                Arguments.of("1+1=?", 2)//
                , Arguments.of("1+2=?", 3)
        );
    }

    @Test void shouldReturnMinusOneForUnknownRune() {
        var input = "A";

        var sum = Runes.solveExpression(input);

        assertEquals(-1, sum);
    }

    @ParameterizedTest @MethodSource("sumOfTwoNumbers") void shouldSumTwoNumbers(String input, int expected) {
        var sum = Runes.solveExpression(input);

        assertEquals(expected, sum);
    }


    @Disabled("TDD in progress") @Test void testSample() {
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