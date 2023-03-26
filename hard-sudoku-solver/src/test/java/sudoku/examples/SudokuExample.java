package sudoku.examples;

import java.util.Arrays;
import java.util.Random;

public record SudokuExample(int[][] solution, int[][] puzzle) {

    public SudokuExample(int[][] solution) {
        this(solution, null);
    }

    private static void replaceRandomCellWithValue(int[][] grid, int newValue) {
        var random = new Random();
        var x = random.nextInt(9);
        var y = random.nextInt(9);
        grid[x][y] = newValue;
    }

    public int[][] withTwoMissingTwoCellsInSameSubgrid() {
        var example = Arrays.stream(solution).map(int[]::clone).toArray(int[][]::new);
        var random = new Random();
        var row = 0;
        var col = 0;
        var anotherRow = random.nextInt(2);
        while (anotherRow == row) {
            anotherRow = random.nextInt(2);
        }
        var anotherCandidateInSameCol = example[anotherRow][col];
        example[anotherRow][col] = 0;

        for (int i = 0; i < example[row].length; i++) {
            var anotherCandidateInSameRow = example[row][i];
            if (anotherCandidateInSameRow == anotherCandidateInSameCol) {
                example[row][i] = 0;
            }
        }
        example[row][col] = 0;

        return example;
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

}
