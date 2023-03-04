package solution.part_two;

public class MorseCodeDecoder {

    private MorseCodeDecoder() {

    }

    public static String decodeBits(String bits) {

        var samplingRate = MorseDecoderSampleRate.getSamplingRate(bits);

        var spaceBetweenWords = "0000000".repeat(samplingRate);
        var spaceBetweenChars = "000".repeat(samplingRate);
        var dash = "111".repeat(samplingRate);
        var dot = "1".repeat(samplingRate);
        var spaceBetweenSymbols = "0".repeat(samplingRate);

        return bits.replace(spaceBetweenWords, "   ")
                   .replace(spaceBetweenChars, " ")
                   .replace(dash, "-")
                   .replace(dot, ".")
                   .replace(spaceBetweenSymbols, "");
    }

    public static String decodeMorse(String morseCode) {
        return solution.part_one.MorseCodeDecoder.decode(morseCode);
    }
}