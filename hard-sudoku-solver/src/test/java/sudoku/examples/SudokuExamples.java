package sudoku.examples;

import java.util.Arrays;
import java.util.Random;

public class SudokuExamples {

    private SudokuExamples() {
    }

    public static class FULL_9X9_EXAMPLE {

        private static final int[][] SOLUTION = new int[][]{
                {4, 3, 5, 2, 6, 9, 7, 8, 1},
                {6, 8, 2, 5, 7, 1, 4, 9, 3},
                {1, 9, 7, 8, 3, 4, 5, 6, 2},
                {8, 2, 6, 1, 9, 5, 3, 4, 7},
                {3, 7, 4, 6, 8, 2, 9, 1, 5},
                {9, 5, 1, 7, 4, 3, 6, 2, 8},
                {5, 1, 9, 3, 2, 6, 8, 7, 4},
                {2, 4, 8, 9, 5, 7, 1, 3, 6},
                {7, 6, 3, 4, 1, 8, 2, 5, 9}
        };

        private FULL_9X9_EXAMPLE() {
        }

        public static int[][] withInvalidValue() {
            var example = Arrays.stream(SOLUTION).map(int[]::clone).toArray(int[][]::new);

            var random = new Random();
            var invalidValue = random.nextInt(10) + 10;
            replaceRandomCellWithValue(example, invalidValue);

            return example;
        }

        public static int[][] withNMissingCells(int numberOfMissingCells) {
            var example = Arrays.stream(SOLUTION).map(int[]::clone).toArray(int[][]::new);
            
            for (int i = 0; i < numberOfMissingCells; i++) {
                replaceRandomCellWithValue(example, 0);
            }

            return example;
        }

        private static void replaceRandomCellWithValue(int[][] grid, int newValue) {
            var random = new Random();
            var x = random.nextInt(9);
            var y = random.nextInt(9);
            grid[x][y] = newValue;
        }


        public static int[][] getSolution() {
            return SOLUTION;
        }
    }


}
