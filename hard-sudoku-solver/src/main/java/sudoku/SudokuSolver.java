package sudoku;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SudokuSolver {

    private static final String INVALID_GRID_SIZE = "Invalid grid size";
    private static final String INVALID_GRID_VALUE = "Invalid grid value";
    private final int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public int[][] solve() {
        validateGridIs9x9();
        return grid;
    }

    private void validateGridIs9x9() {
        if (grid == null || grid.length != 9) {
            throw new IllegalArgumentException(INVALID_GRID_SIZE);
        }
        for (var row : grid) {
            if (row.length != 9) {
                throw new IllegalArgumentException(INVALID_GRID_SIZE);
            }
            for (var cell : row) {
                if (cell < 0 || cell > 9) {
                    throw new IllegalArgumentException(INVALID_GRID_VALUE);
                }
            }
        }
    }

}