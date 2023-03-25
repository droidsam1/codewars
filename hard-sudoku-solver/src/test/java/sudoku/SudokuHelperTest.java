package sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SudokuHelperTest {

    private static Stream<Arguments> candidatesPerRowAndCol() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 3, 5},//
                        {6, 8, 2}, //
                        {1, 9, 7},//
                }, new int[]{2, 4, 7, 8, 9}, new Cell(0, 0)),//
                Arguments.of(new int[][]{
                        {4, 0, 5},//
                        {6, 8, 2}, //
                        {1, 9, 7},//
                }, new int[]{1, 2, 3, 6, 7}, new Cell(0, 1)),//
                Arguments.of(new int[][]{
                        {4, 3, 5},//
                        {6, 0, 2}, //
                        {1, 9, 7},//
                }, new int[]{1, 4, 5, 7, 8}, new Cell(1, 1)), //
                Arguments.of(new int[][]{
                        {4, 3, 5},//
                        {6, 8, 2}, //
                        {1, 9, 0},//
                }, new int[]{3, 4, 6, 7, 8}, new Cell(2, 2))
        );

    }


    private static Stream<Arguments> candidatesForCell() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 3, 5},//
                        {6, 8, 2}, //
                        {1, 9, 7},//
                }, new int[]{4}, new Cell(0, 0)),//
                Arguments.of(new int[][]{
                        {4, 0, 5},//
                        {6, 8, 2}, //
                        {1, 9, 7},//
                }, new int[]{3}, new Cell(0, 1)),//
                Arguments.of(new int[][]{
                        {4, 3, 5},//
                        {6, 0, 2}, //
                        {1, 9, 7},//
                }, new int[]{8}, new Cell(1, 1)), //
                Arguments.of(new int[][]{
                        {4, 3, 5},//
                        {6, 8, 2}, //
                        {1, 9, 0},//
                }, new int[]{7}, new Cell(2, 2))
        );

    }

    @ParameterizedTest//
    @MethodSource("candidatesPerRowAndCol")//
    void shouldFindCandidatesForMissingCell(int[][] grid, int[] candidates, Cell missingCell) {
        var sudokuSolver = new SudokuHelper(grid);

        assertArrayEquals(candidates, sudokuSolver.candidatesInRowColumn(missingCell.row, missingCell.col));
    }


    @ParameterizedTest//
    @MethodSource("candidatesForCell")//
    void shouldFindCandidatesForMissingCellInTheGrid(int[][] grid, int[] candidates, Cell missingCell) {

        var sudokuSolver = new SudokuHelper(grid);

        assertArrayEquals(candidates, sudokuSolver.findCandidatesInGrid(missingCell.row, missingCell.col));
    }

    private static class Cell {

        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}