import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    static Stream<Arguments> shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly() {
        return Stream.of(
                Arguments.of("0", List.of("0", "8")),
                Arguments.of("1", List.of("1", "2", "4")),
                Arguments.of("2", List.of("1", "2", "3", "5")),
                Arguments.of("3", List.of("2", "3", "6")),
                Arguments.of("4", List.of("1", "4", "7", "5")),
                Arguments.of("5", List.of("2", "4", "5", "6", "8")),
                Arguments.of("6", List.of("3", "5", "6", "9")),
                Arguments.of("7", List.of("7", "8", "4")),
                Arguments.of("8", List.of("0", "5", "7", "8", "9")),
                Arguments.of("9", List.of("6", "8", "9")));
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly(String input, List<String> expected) {

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.containsAll(expected));
        assertTrue(expected.containsAll(digits));
    }

    @Test
    void shouldReturnCombinationsOfPossibleDigits() {

        var input = "11";

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.contains("11"));
        assertTrue(digits.contains("12"));
        assertTrue(digits.contains("14"));
        assertTrue(digits.contains("21"));
        assertTrue(digits.contains("22"));
        assertTrue(digits.contains("24"));
        assertTrue(digits.contains("41"));
        assertTrue(digits.contains("42"));
        assertTrue(digits.contains("44"));
    }


}