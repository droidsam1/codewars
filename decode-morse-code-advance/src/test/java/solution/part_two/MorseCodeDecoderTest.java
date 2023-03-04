package solution.part_two;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static solution.examples.EXAMPLES.HEY_JUDE_EXAMPLE;
import static solution.part_two.MorseCodeDecoder.decodeBits;
import static solution.part_two.MorseCodeDecoder.decodeMorse;

import org.junit.jupiter.api.Test;

class MorseCodeDecoderTest {

    @Test void shouldBeAbleToDecodeSimpleLetterAtSimpleRate() {
        assertThat(decodeMorse(decodeBits("1")), is("E"));
        assertThat(decodeMorse(decodeBits("10111")), is("A"));
        assertThat(decodeMorse(decodeBits("101010")), is("S"));
        assertThat(decodeMorse(decodeBits("111")), is("E"));
        assertThat(decodeMorse(decodeBits("01110")), is("E"));
        assertThat(decodeMorse(decodeBits("1110111")), is("M"));
        assertThat(decodeMorse(decodeBits("10001")), is("EE"));
        assertThat(decodeMorse(decodeBits("111000000000111")), is("EE"));
    }

    @Test void shouldBeAbleToDecodeSentenceAtSimpleRate() {
        assertThat(decodeBits(HEY_JUDE_EXAMPLE.getBinaryString()), is(HEY_JUDE_EXAMPLE.getMorseString()));

        assertThat(decodeMorse(decodeBits(HEY_JUDE_EXAMPLE.getBinaryString())),
                   is(HEY_JUDE_EXAMPLE.getEnglishString())
        );
    }

    @Test void testExampleFromDescription() {
        assertThat(
                decodeMorse(decodeBits(
                        "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")),
                is("HEY JUDE")
        );
    }

}
