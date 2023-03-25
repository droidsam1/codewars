package sudoku;

public class SudokuSolver {

    private final int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public int[][] solve() {
        validateGridIs9x9();
        return null;
    }

    private void validateGridIs9x9() {
        if (grid == null || grid.length != 9) {
            throw new IllegalArgumentException("Invalid grid size");
        }
        for (var row : grid) {
            if (row.length != 9) {
                throw new IllegalArgumentException("Invalid grid size");
            }
            for (var cell : row) {
                if (cell < 0 || cell > 9) {
                    throw new IllegalArgumentException("Invalid grid size");
                }
            }
        }
    }

}