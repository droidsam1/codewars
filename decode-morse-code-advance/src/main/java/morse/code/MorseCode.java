package morse.code;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    private static final Map<String, String> morseCodeMap = buildMorseCodeMap();

    private MorseCode() {
    }

    public static String get(String morseCode) {
        return morseCodeMap.get(morseCode.toUpperCase());
    }

    private static Map<String, String> buildMorseCodeMap() {
        var morseCodeMap = new HashMap<String, String>();
        morseCodeMap.putAll(MORSE_CODE_ALPHABET.toMorseMap());
        morseCodeMap.putAll(MORSE_CODE_NUMBERS.toMorseMap());
        return morseCodeMap;
    }
}
