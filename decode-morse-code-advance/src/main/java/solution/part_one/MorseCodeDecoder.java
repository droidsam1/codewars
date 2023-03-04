package solution.part_one;

import java.util.Arrays;
import java.util.stream.Collectors;
import morse.code.MorseCode;

public class MorseCodeDecoder {

    private static final String MORSE_WORD_SEPARATOR = " {3}";
    private static final String MORSE_CHARACTER_SEPARATOR = " ";

    private MorseCodeDecoder() {
    }

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split(MORSE_WORD_SEPARATOR))
                     .map(word -> Arrays.stream(word.split(MORSE_CHARACTER_SEPARATOR))
                                        .map(MorseCode::get)
                                        .collect(Collectors.joining()))
                     .collect(Collectors.joining(" "));
    }
}