package solution.part_two;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static solution.part_two.MorseCodeDecoder.decodeBits;
import static solution.part_two.MorseCodeDecoder.decodeMorse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MorseCodeDecoderTest {

    @Test void shouldBeAbleToDecodeSimpleLetterAtSimpleRate() {
        assertThat(decodeMorse(decodeBits("1")), is("E"));
        assertThat(decodeMorse(decodeBits("10")), is("A"));
        assertThat(decodeMorse(decodeBits("111")), is("S"));
    }

    @Test void shouldBeAbleToDecodeSentenceAtSimpleRate() {
        assertThat(decodeBits("1111 1 0100   1000 110 011 1"), is(".... . -.--   .--- ..- -.. ."));
    }

    @Disabled @Test void testExampleFromDescription() {
        assertThat(
                decodeMorse(decodeBits(
                        "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")),
                is("HEY JUDE")
        );
    }
}
