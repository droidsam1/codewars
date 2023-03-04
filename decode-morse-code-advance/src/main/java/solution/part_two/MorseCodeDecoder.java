package solution.part_two;

import morse.code.MorseCode;

public class MorseCodeDecoder {

    private MorseCodeDecoder() {
    }

    public static String decodeBits(String bits) {
        return bits.replace("1", ".").replace("0", "-");
    }

    public static String decodeMorse(String morseCode) {
        return MorseCode.get(morseCode);
    }
}