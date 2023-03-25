package sudoku;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HardSudokuSolverTests {


    @Test void shouldFailWhenGridIsEmpty() {
        var invalidGrid = new int[][]{};
        var sudokuSolver = new SudokuSolver(invalidGrid);

        assertThrows(IllegalArgumentException.class, sudokuSolver::solve);
    }

    @Test void shouldFailWhenGridIsNull() {
        var sudokuSolver = new SudokuSolver(null);

        assertThrows(IllegalArgumentException.class, sudokuSolver::solve);
    }

    @Test void shouldFailWhenGridIsNotA9x9() {
        var gridSize = new Random().nextInt(9);
        var invalidGrid = new int[gridSize][gridSize];
        var sudokuSolver = new SudokuSolver(invalidGrid);

        assertThrows(IllegalArgumentException.class, sudokuSolver::solve);
    }


    @Test @Disabled("while developing the solution with TDDs") void sampleTest() {

        int[][] puzzle = {
                {0, 0, 6, 1, 0, 0, 0, 0, 8},
                {0, 8, 0, 0, 9, 0, 0, 3, 0},
                {2, 0, 0, 0, 0, 5, 4, 0, 0},
                {4, 0, 0, 0, 0, 1, 8, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 4, 0},
                {0, 0, 7, 9, 0, 0, 0, 0, 3},
                {0, 0, 8, 4, 0, 0, 0, 0, 6},
                {0, 2, 0, 0, 5, 0, 0, 8, 0},
                {1, 0, 0, 0, 0, 2, 5, 0, 0}
        },

                solution = {
                        {3, 4, 6, 1, 2, 7, 9, 5, 8},
                        {7, 8, 5, 6, 9, 4, 1, 3, 2},
                        {2, 1, 9, 3, 8, 5, 4, 6, 7},
                        {4, 6, 2, 5, 3, 1, 8, 7, 9},
                        {9, 3, 1, 2, 7, 8, 6, 4, 5},
                        {8, 5, 7, 9, 4, 6, 2, 1, 3},
                        {5, 9, 8, 4, 1, 3, 7, 2, 6},
                        {6, 2, 4, 7, 5, 9, 3, 8, 1},
                        {1, 7, 3, 8, 6, 2, 5, 9, 4}
                };

        assertArrayEquals(solution, new SudokuSolver(puzzle).solve());
    }
}