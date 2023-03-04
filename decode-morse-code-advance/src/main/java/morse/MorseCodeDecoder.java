package morse;

import morse.code.MorseCode;

public class MorseCodeDecoder {

    public static String decodeBits(String bits) {
        return ".";
    }

    public static String decodeMorse(String morseCode) {
        return MorseCode.get(morseCode);
    }
}