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

    public String getMorseString() {
        return morseString;
    }

    public String getEnglishString() {
        return englishString;
    }
}
