public class Snail {

    public static int[] snail(int[][] array) {
        var arraySize = array[0].length;
        if (arraySize == 0) {
            return new int[]{};
        }
        if (arraySize == 1) {
            return new int[]{array[0][0]};
        }

        var result = new int[arraySize * arraySize];
        var resultIndex = 0;

        var lastRowIndex = array.length;
        var lastColumnIndex = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            if (i < lastRowIndex) {
                for (int j = i; j < lastColumnIndex; j++) {
                    result[resultIndex++] = (array[i][j]);
                }
                //put last column
                for (int k = i + 1; k < lastColumnIndex - 1; k++) {
                    result[resultIndex++] = (array[k][lastColumnIndex - 1]);
                }
                lastColumnIndex--;

                //reverse the last line
                if (i < lastRowIndex - 1) {
                    for (int j = lastColumnIndex; j >= i; j--) {
                        result[resultIndex++] = (array[lastRowIndex - 1][j]);
                    }
                    lastRowIndex--;
                }

                //put first row reversed
                for (int k = lastRowIndex - 1; k > i; k--) {
                    result[resultIndex++] = (array[k][i]);
                }
            }
        }

        return result;
    }
}