package solution.part_two;

public class MorseDecoderSampleRate {

    private MorseDecoderSampleRate() {
        
    }

    public static int getSamplingRate(String bits) {
        var bitsArray = bits.toCharArray();
        int sampleRate = 0;
        int minimumSampleRate = Integer.MAX_VALUE;
        boolean thereIsZeros = false;

        for (char bit : bitsArray) {
            if (bit == '1') {
                sampleRate++;
            } else {
                thereIsZeros = true;
                if (sampleRate > 0 && sampleRate < minimumSampleRate) {
                    minimumSampleRate = sampleRate;
                }
                sampleRate = 0;
            }
        }
        if (!thereIsZeros) {
            return 1;
        }
        return minimumSampleRate;
    }
}
