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

        var lastNonVisitedRowIndex = arraySize - 1;
        var lastNonVisitedColumnIndex = arraySize - 1;

        for (int i = 0; i < arraySize - 1; i++) {
            //go right
            for (int j = i; j <= lastNonVisitedColumnIndex; j++) {
                result[resultIndex++] = array[i][j];
            }
            //go down
            for (int k = i + 1; k <= lastNonVisitedColumnIndex; k++) {
                result[resultIndex++] = array[k][lastNonVisitedColumnIndex];
            }
            lastNonVisitedColumnIndex--;

            //go left
            for (int j = lastNonVisitedColumnIndex; j >= i && i < lastNonVisitedRowIndex; j--) {
                result[resultIndex++] = array[lastNonVisitedRowIndex][j];
            }
            lastNonVisitedRowIndex--;

            //go up
            for (int k = lastNonVisitedRowIndex; k > i; k--) {
                result[resultIndex++] = array[k][i];
            }
        }

        return result;
    }
}