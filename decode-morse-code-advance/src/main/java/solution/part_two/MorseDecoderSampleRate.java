package solution.part_two;

public class MorseDecoderSampleRate {

    private MorseDecoderSampleRate() {

    }

    public static int getSamplingRate(String bits) {
        var bitsArray = bits.replaceAll("0+$", "").replaceAll("^0+", "").toCharArray();
        int minNumZerosBetweenOnes = Integer.MAX_VALUE;
        int minNumOnesBetweenZeros = Integer.MAX_VALUE;

        var numZeros = 0;
        var numOnes = 0;
        for (char bit : bitsArray) {

            if (bit == '0') {
                numZeros++;
                if (numOnes > 0 && numZeros < minNumOnesBetweenZeros) {
                    minNumOnesBetweenZeros = numOnes;
                }
                numOnes = 0;
            } else {
                numOnes++;
                if (numZeros > 0 && numZeros < minNumZerosBetweenOnes) {
                    minNumZerosBetweenOnes = numZeros;
                }
                numZeros = 0;
            }
        }
        if (minNumZerosBetweenOnes == Integer.MAX_VALUE && minNumOnesBetweenZeros == Integer.MAX_VALUE) {
            return bitsArray.length;
        }

        return Math.min(minNumZerosBetweenOnes, minNumOnesBetweenZeros);
    }
}
