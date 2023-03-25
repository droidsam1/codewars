package sudoku.examples;

import java.util.Arrays;
import java.util.Random;

public class SudokuExample {

    private final int[][] solution;

    public SudokuExample(int[][] solution) {
        this.solution = solution;
    }

    private static void replaceRandomCellWithValue(int[][] grid, int newValue) {
        var random = new Random();
        var x = random.nextInt(9);
        var y = random.nextInt(9);
        grid[x][y] = newValue;
    }

    public int[][] withInvalidValue() {
        var example = Arrays.stream(solution).map(int[]::clone).toArray(int[][]::new);

        var random = new Random();
        var invalidValue = random.nextInt(10) + 10;
        replaceRandomCellWithValue(example, invalidValue);

        return example;
    }

    public int[][] withNMissingCells(int numberOfMissingCells) {
        var example = Arrays.stream(solution).map(int[]::clone).toArray(int[][]::new);

        for (int i = 0; i < numberOfMissingCells; i++) {
            replaceRandomCellWithValue(example, 0);
        }

        return example;
    }

    public int[][] getSolution() {
        return solution;
    }

}
