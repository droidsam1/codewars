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
        assertThat(decodeBits("10101010001000111010111011100000001011101110111000101011100011101010001"),
                   is(".... . -.--   .--- ..- -.. .")
        );

        assertThat(
                decodeMorse(decodeBits("10101010001000111010111011100000001011101110111000101011100011101010001")),
                is("HEY JUDE")
        );
    }

    @Disabled @Test void testExampleFromDescription() {
        assertThat(
                decodeMorse(decodeBits(
                        "1100110011001100 0000 11 0000 00111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")),
                is("HEY JUDE")
        );
    }
}
