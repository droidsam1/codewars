package morse.code;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

enum MORSE_CODE_ALPHABET {
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
                     .collect(toMap(morse -> morse.morseCode, morse -> morse.englishCode));
    }
}
