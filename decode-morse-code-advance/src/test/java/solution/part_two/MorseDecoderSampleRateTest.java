package solution.part_two;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static solution.examples.EXAMPLES.HEY_JUDE_EXAMPLE;
import static solution.part_two.MorseDecoderSampleRate.getSamplingRate;

import org.junit.jupiter.api.Test;

class MorseDecoderSampleRateTest {

    @Test void shouldGetSamplingRate() {
        assertThat(getSamplingRate("1"), is(1));
        assertThat(getSamplingRate("10"), is(1));
        assertThat(getSamplingRate("111"), is(1));
        assertThat(getSamplingRate("1100"), is(2));
        assertThat(getSamplingRate(HEY_JUDE_EXAMPLE.getBinaryString()), is(1));
        assertThat(getSamplingRate(HEY_JUDE_EXAMPLE.getBinaryString(2)), is(2));
        assertThat(getSamplingRate(HEY_JUDE_EXAMPLE.getBinaryString(4)), is(4));
    }
}