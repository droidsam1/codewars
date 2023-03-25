package sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SudokuHelperTest {

    public static Stream<Arguments> candidatesPerRowAndCol() {
        return Stream.of(Arguments.of(new int[][]{
                                 {0, 3, 5},//
                                 {6, 8, 2}, //
                                 {1, 9, 7},//
                         }, new int[]{2, 4, 7, 8, 9})

        );

    }

    @ParameterizedTest @MethodSource("candidatesPerRowAndCol")
    void shouldFindCandidatesForMissingCellInRowAndCol(int[][] grid, int[] candidates) {
        var sudokuSolver = new SudokuHelper(grid);

        assertArrayEquals(candidates, sudokuSolver.candidatesInRowColumn(0));
    }

    @Test void shouldFindCandidatesForMissingCellInTheGrid() {
        var onlyOneMissingCellInput = new int[][]{
                {0, 3, 5},//
                {6, 8, 2}, //
                {1, 9, 7},//
        };
        var expectedCandidatesForMissingCell = new int[]{4};

        var sudokuSolver = new SudokuHelper(onlyOneMissingCellInput);

        assertArrayEquals(expectedCandidatesForMissingCell, sudokuSolver.findCandidatesInGrid());
    }


}