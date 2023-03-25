package sudoku;

public class SudokuSolver {

    private static final String INVALID_GRID_SIZE = "Invalid grid size";
    private static final String INVALID_GRID_VALUE = "Invalid grid value";
    private final int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public int[][] solve() {
        validateGridIs9x9();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    var candidatesForCell = new SudokuHelper(grid).findCandidatesForCellInItsOwnSubgrid(i, j);
                    if (candidatesForCell.length == 1) {
                        grid[i][j] = candidatesForCell[0];
                    }else{
                        var candidatesPerRowAndCol = new SudokuHelper(grid).candidates(i,j);
                        if(candidatesPerRowAndCol.length == 1){
                            grid[i][j] = candidatesPerRowAndCol[0];
                        }

                    }
                }
            }
        }

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