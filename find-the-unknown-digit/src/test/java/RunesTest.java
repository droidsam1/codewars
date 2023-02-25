import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import runes.Runes;

class RunesTest {

    static Stream<Arguments> sumOfTwoNumbers() {
        return Stream.of(
                Arguments.of("1+1=?", 2), //
                Arguments.of("1+2=?", 3), //
                Arguments.of("3+3=?", 6) //
        );
    }

    static Stream<Arguments> multiplyOfTwoNumbers() {
        return Stream.of(Arguments.of("2*2=?", 4) //
        );
    }

    static Stream<Arguments> missingNumberInSums() {
        return Stream.of(
                Arguments.of("1+?=3", 2), //
                Arguments.of("?+?=2", 1), //
                Arguments.of("?+1=1", 0), //
                Arguments.of("?+?=?", 0), //
                Arguments.of("??+??=??", -1) //
        );
    }


    @ParameterizedTest @ValueSource(strings = {"00+01=?", "00+1=?", "1+01=?", "1+A=?", "A"})
    void shouldReturnMinusOneForUnknownRunes(String input) {
        var sum = Runes.solveExpression(input);

        assertEquals(-1, sum);
    }

    @ParameterizedTest @MethodSource("sumOfTwoNumbers") void shouldSumTwoNumbers(String input, int expected) {
        var sum = Runes.solveExpression(input);

        assertEquals(expected, sum);
    }

    @ParameterizedTest @MethodSource("multiplyOfTwoNumbers") void shouldMultiplyTwoNumbers(String input, int expected) {
        var sum = Runes.solveExpression(input);

        assertEquals(expected, sum);
    }

    @ParameterizedTest
    @MethodSource("missingNumberInSums")
    void shouldFindTheMissingNumberInSums(String input, int expected) {
        var sum = Runes.solveExpression(input);

        assertEquals(expected, sum);
    }


    @Test void testSample() {
        assertEquals(2, Runes.solveExpression("1+1=?"), "Answer for expression '1+1=?' ");
        assertEquals(6, Runes.solveExpression("123*45?=5?088"), "Answer for expression '123*45?=5?088' ");
        assertEquals(0, Runes.solveExpression("-5?*-1=5?"), "Answer for expression '-5?*-1=5?' ");
        assertEquals(-1, Runes.solveExpression("19--45=5?"), "Answer for expression '19--45=5?' ");
        assertEquals(5, Runes.solveExpression("??*??=302?"), "Answer for expression '??*??=302?' ");
        assertEquals(2, Runes.solveExpression("?*11=??"), "Answer for expression '?*11=??' ");
        assertEquals(2, Runes.solveExpression("??*1=??"), "Answer for expression '??*1=??' ");
        assertEquals(-1, Runes.solveExpression("??+??=??"), "Answer for expression '??+??=??' ");
    }

    @Test void testEdgeCase() {
        assertEquals(8,
                     Runes.solveExpression("-?56373--9216=-?47157"),
                     "Answer for expression '-?56373--9216=-?47157' "
        );
    }

}