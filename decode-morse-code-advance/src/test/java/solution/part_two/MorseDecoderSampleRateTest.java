package solution.part_two;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static solution.part_two.MorseDecoderSampleRate.getSamplingRate;

import org.junit.jupiter.api.Test;

class MorseDecoderSampleRateTest {

    private static final String EXAMPLE_SENTENCE = "111110010000010000110001101";

    @Test void shouldGetSamplingRate() {
        assertThat(getSamplingRate("1"), is(1));
        assertThat(getSamplingRate("10"), is(1));
        assertThat(getSamplingRate("111"), is(1));
        assertThat(getSamplingRate("1100"), is(2));
        assertThat(getSamplingRate(EXAMPLE_SENTENCE), is(1));
        assertThat(getSamplingRate(withNewSampling(EXAMPLE_SENTENCE, 2)), is(2));
        assertThat(getSamplingRate(withNewSampling(EXAMPLE_SENTENCE, 4)), is(4));
    }

    private String withNewSampling(String input, int samplesPerSymbol) {
        var array = input.toCharArray();
        var result = new StringBuilder();
        for (char c : array) {
            result.append(String.valueOf(c).repeat(samplesPerSymbol));
        }
        return result.toString();
    }
}