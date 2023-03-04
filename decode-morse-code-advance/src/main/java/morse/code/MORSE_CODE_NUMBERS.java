package morse.code;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

enum MORSE_CODE_NUMBERS {
    ZERO("-----", "0"),//
    ONE(".----", "1"),//
    TWO("..---", "2"),//
    THREE("...--", "3"),//
    FOUR("....-", "4"),//
    FIVE(".....", "5"),//
    SIX("-....", "6"),//
    SEVEN("--...", "7"),//
    EIGHT("---..", "8"),//
    NINE("----.", "9h");//


    private final String morseCode;
    private final String englishCode;

    MORSE_CODE_NUMBERS(String morseCode, String englishCode) {
        this.morseCode = morseCode;
        this.englishCode = englishCode;
    }

    public static Map<String, String> toMorseMap() {
        return Arrays.stream(MORSE_CODE_NUMBERS.values())
                     .collect(toMap(morse -> morse.morseCode, morse -> morse.englishCode));
    }
}
