package sudoku;

public class SudokuSolver {

    private final int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public int[][] solve() {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("Invalid grid size");
        }
        return null;
    }
}