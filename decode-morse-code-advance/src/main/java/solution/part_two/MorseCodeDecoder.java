package solution.part_two;


public class MorseCodeDecoder {

    private MorseCodeDecoder() {
    }

    public static String decodeBits(String bits) {
        return bits.replace("1", ".").replace("0", "-");
    }

    public static String decodeMorse(String morseCode) {
        return solution.part_one.MorseCodeDecoder.decode(morseCode);
    }
}