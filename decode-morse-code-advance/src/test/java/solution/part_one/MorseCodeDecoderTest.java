package solution.part_one;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

class MorseCodeDecoderTest {

    @Test void shouldReturnEnglish() {

        var decodedMessage = MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .");

        assertThat(decodedMessage, CoreMatchers.is("HEY JUDE"));
    }
}