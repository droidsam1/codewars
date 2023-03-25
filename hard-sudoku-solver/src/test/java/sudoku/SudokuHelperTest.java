package sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SudokuHelperTest {


    @Test void shouldFindCandidatesInRowForMissingCell() {
        var onlyOneMissingCellInput = new int[][]{
                {0, 3, 5},//
                {6, 8, 2}, //
                {1, 9, 7},//
        };
        var expectedCandidatesForMissingCell = new int[]{1, 2, 4, 6, 7, 8, 9};

        var sudokuSolver = new SudokuHelper(onlyOneMissingCellInput);

        assertArrayEquals(expectedCandidatesForMissingCell, sudokuSolver.candidatesInRow(0));
    }

    @Test void shouldFindCandidatesInColumnForMissingCell() {
        var onlyOneMissingCellInput = new int[][]{
                {0, 3, 5},//
                {6, 8, 2}, //
                {1, 9, 7},//
        };
        var expectedCandidatesForMissingCell = new int[]{2, 3, 4, 5, 7, 8, 9};

        var sudokuSolver = new SudokuHelper(onlyOneMissingCellInput);

        assertArrayEquals(expectedCandidatesForMissingCell, sudokuSolver.candidatesInColumn(0));
    }

}