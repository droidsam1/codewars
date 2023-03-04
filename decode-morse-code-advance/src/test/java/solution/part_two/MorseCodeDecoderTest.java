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
        assertThat(decodeBits(EXAMPLES.HEY_JUDE.getBinaryString()), is(EXAMPLES.HEY_JUDE.getMorseString()));
        assertThat(decodeMorse(decodeBits(EXAMPLES.HEY_JUDE.getBinaryString())),
                   is(EXAMPLES.HEY_JUDE.getEnglishString())
        );
    }

    @Disabled("Disable while developing with TDD") @Test void testExampleFromDescription() {
        assertThat(
                decodeMorse(decodeBits(
                        "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")),
                is("HEY JUDE")
        );
    }

    enum EXAMPLES {
        HEY_JUDE(
                "10101010001000111010111011100000001011101110111000101011100011101010001",
                ".... . -.--   .--- ..- -.. .",
                "HEY JUDE"
        );

        private final String binaryString;
        private final String morseString;
        private final String englishString;

        EXAMPLES(String binaryString, String morseString, String englishString) {
            this.binaryString = binaryString;
            this.morseString = morseString;
            this.englishString = englishString;
        }

        public String getBinaryString() {
            return binaryString;
        }

        public String getMorseString() {
            return morseString;
        }

        public String getEnglishString() {
            return englishString;
        }
    }
}
