package solution.examples;

public enum EXAMPLES {
    HEY_JUDE_EXAMPLE(
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

    public String getBinaryString(int withSamplingRateOf) {
        return withNewSampling(binaryString, withSamplingRateOf);
    }

    public String getMorseString() {
        return morseString;
    }

    public String getEnglishString() {
        return englishString;
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
