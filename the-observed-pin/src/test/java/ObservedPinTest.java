import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    static Stream<Arguments> shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly() {
        return Stream.of(//
                Arguments.of("0", List.of("0", "8")),//
                Arguments.of("1", List.of("1", "2", "4")),//
                Arguments.of("2", List.of("1", "2", "3", "5")),//
                Arguments.of("3", List.of("2", "3", "6")),//
                Arguments.of("4", List.of("1", "4", "7", "5")),//
                Arguments.of("5", List.of("2", "4", "5", "6", "8")),//
                Arguments.of("6", List.of("3", "5", "6", "9")),//
                Arguments.of("7", List.of("7", "8", "4")),//
                Arguments.of("8", List.of("0", "5", "7", "8", "9")),//
                Arguments.of("9", List.of("6", "8", "9")));
    }

    static Stream<Arguments> shouldReturnCombinationsOfInputDigits() {
        return Stream.of(//
                Arguments.of("11", List.of("11", "12", "14", "21", "22", "24", "41", "42", "44")),//
                Arguments.of("22", List.of("11", "12", "13", "15", "21", "22", "23", "25", "31", "32", "33", "35", "51", "52", "53", "55")), //
                Arguments.of("369", List.of("236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299", "336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636", "638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699")));
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly(String input, List<String> expected) {

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.containsAll(expected));
        assertTrue(expected.containsAll(digits));
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnCombinationsOfInputDigits(String input, List<String> expected) {

        var digits = ObservedPin.getPINs(input);

        assertEquals(expected.stream().sorted().collect(Collectors.toList()), digits.stream().sorted().collect(Collectors.toList()), "For observed PIN " + input);
    }


}