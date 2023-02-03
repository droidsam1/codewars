import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static int[] snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        var lastRowIndex = array.length;
        for (int i = 0; i < array.length; i++) {
            if (i < lastRowIndex) {
                for (int j = 0; j < array[i].length; j++) {
                    result.add(array[i][j]);
                }
                //reverse the last line
                if (i < lastRowIndex - 1) {
                    for (int j = array[i].length - 1; j >= 0; j--) {
                        result.add(array[lastRowIndex - 1][j]);
                    }
                    lastRowIndex--;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}