package morse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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


    protected enum MORSE_CODE_ALPHABET {
        A(".-", "A"),//
        B("-...", "B"),//
        C("-.-.", "C"),//
        D("-..", "D"),//
        E(".", "E"),//
        F("..-.", "F"),//
        G("--.", "G"),//
        H("....", "H"),//
        I("..", "I"),//
        J(".---", "J"),//
        K("-.-", "K"),//
        L(".-..", "L"),//
        M("--", "M"),//
        N("-.", "N"),//
        O("---", "O"),//
        P(".--.", "P"),//
        Q("--.-", "Q"),//
        R(".-.", "R"),//
        S("...", "S"),//
        T("-", "T"),//
        U("..-", "U"),//
        V("...-", "V"),//
        W(".--", "W"),//
        X("-..-", "X"),//
        Y("-.--", "Y"),//
        Z("--..", "Z");


        private final String morseCode;
        private final String englishCode;

        MORSE_CODE_ALPHABET(String morseCode, String englishCode) {
            this.morseCode = morseCode;
            this.englishCode = englishCode;
        }

        public static Map<String, String> toMorseMap() {
            return Arrays.stream(MORSE_CODE_ALPHABET.values())
                         .collect(Collectors.toMap(morse -> morse.morseCode, morse -> morse.englishCode));
        }
    }


    private enum MORSE_CODE_NUMBERS {
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
                         .collect(Collectors.toMap(morseCodeNumbers -> morseCodeNumbers.morseCode,
                                                   morseCodeNumbers -> morseCodeNumbers.englishCode
                         ));
        }
    }

}
