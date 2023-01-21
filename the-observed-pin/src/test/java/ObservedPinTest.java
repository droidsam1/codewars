import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    public static Stream<Arguments> shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly() {
        return Stream.of(
                Arguments.of("0", List.of("0", "8")),
                Arguments.of("1", List.of("1", "2", "4")),
                Arguments.of("2", List.of("1", "2", "3", "5")),
                Arguments.of("3", List.of("3", "2", "6")),
                Arguments.of("7", List.of("7", "8", "4")),
                Arguments.of("9", List.of("9", "6", "8")));
    }

    @Test
    void shouldReturnTheSameInputDigitWhenInputIsOneDigitOnly() {
        var input = "1";

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.contains(input));
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly(String input, List<String> expected) {

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.containsAll(expected));
        assertTrue(expected.containsAll(digits));
    }


}