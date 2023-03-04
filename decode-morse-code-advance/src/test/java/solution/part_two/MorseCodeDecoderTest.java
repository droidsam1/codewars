package solution.part_two;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MorseCodeDecoderTest {

    @Test void shouldBeAbleToDecodeSimpleLetter() {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits("1")), is("E"));
    }

    @Disabled @Test void testExampleFromDescription() {
        assertThat(
                MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits(
                        "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")),
                is("HEY JUDE")
        );
    }
}
