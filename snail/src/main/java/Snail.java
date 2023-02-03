import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static int[] snail(int[][] array) {
        if (array.length == 1 && array[0].length == 0) {
            return new int[]{};
        }

        List<Integer> result = new ArrayList<>();
        var lastRowIndex = array.length;
        var lastColumnIndex = array.length;
        for (int i = 0; i < array.length; i++) {
            if (i < lastRowIndex) {
                for (int j = i; j < lastColumnIndex; j++) {
                    result.add(array[i][j]);
                }
                //put last column
                for (int k = i + 1; k < lastColumnIndex - 1; k++) {
                    result.add(array[k][lastColumnIndex - 1]);
                }
                lastColumnIndex--;

                //reverse the last line
                if (i < lastRowIndex - 1) {
                    for (int j = array[i].length - 1; j >= 0; j--) {
                        result.add(array[lastRowIndex - 1][j]);
                    }
                    lastRowIndex--;
                }

                //put first row reversed
                for (int k = lastRowIndex - 1; k > i; k--) {
                    result.add(array[k][i]);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}