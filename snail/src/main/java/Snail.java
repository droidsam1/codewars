import java.util.Arrays;

public class Snail {

    public static int[] snail(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).toArray();
    }
}