import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    @Test
    void shouldReturnTheSameInputDigitWhenInputIsOneDigitOnly() {
        var input = "1";

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.contains(input));
    }

    @Test
    void shouldReturnAdjacentDigitsWhenInputIsOneDigitOnly() {
        var input = "1";
        var expected = List.of("1", "2", "4");

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.containsAll(expected));
    }


}