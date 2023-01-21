import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObservedPinTest {


    @Test
    void shouldReturnTheSameInputDigitWhenInputIsOneDigitOnly() {
        var input = "1";

        var digits = ObservedPin.getPINs(input);

        assertTrue(digits.contains(input));
    }


}