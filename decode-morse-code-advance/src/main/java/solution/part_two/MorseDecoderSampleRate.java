package solution.part_two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseDecoderSampleRate {

    private MorseDecoderSampleRate() {

    }

    public static int getSamplingRate(String bits) {
        String trimmedBits = bits.replaceAll("(^0+)|(0+$)", "");
        int rate = Integer.MAX_VALUE;
        Matcher matcher = Pattern.compile("1+|0+").matcher(trimmedBits);
        while (matcher.find()) {
            rate = Math.min(rate, matcher.group().length());
        }
        return rate;
    }
}
