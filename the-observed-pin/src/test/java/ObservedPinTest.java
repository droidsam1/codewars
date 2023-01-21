import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    public static Stream<Arguments> shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly() {
        return Stream.of(Arguments.of("1", List.of("1", "2", "4")));
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
    }


}