package sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SudokuHelperTest {
    
    @Test void shouldFindCandidatesMissingCell() {
        var onlyOneMissingCellInput = new int[][]{
                {0, 3, 5},//
                {6, 8, 2}, //
                {1, 9, 7},//
        };
        var expectedCandidatesForMissingCell = new int[]{2, 4, 7, 8, 9};

        var sudokuSolver = new SudokuHelper(onlyOneMissingCellInput);

        assertArrayEquals(expectedCandidatesForMissingCell, sudokuSolver.candidatesInRowColumn(0));
    }

}