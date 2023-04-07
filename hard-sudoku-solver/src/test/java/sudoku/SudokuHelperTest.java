package sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static sudoku.examples.IntermediateSudokuExamples.INTERMEDIATE_EXAMPLE_2_PUZZLE;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sudoku.examples.IntermediateSudokuExamples.INTERMEDIATE_EXAMPLES;

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
    @MethodSource("candidatesPerRowAndCol")
    void shouldFindCandidatesForMissingCell(int[][] grid, int[] candidates, Cell missingCell) {
        var sudokuSolver = new SudokuHelper(grid);

        assertArrayEquals(candidates, sudokuSolver.candidatesInRowColumn(missingCell.row(), missingCell.col()));
    }


    @ParameterizedTest//
    @MethodSource("candidatesForCell")
    void shouldFindCandidatesForMissingCellInTheGrid(int[][] grid, int[] candidates, Cell missingCell) {

        var sudokuSolver = new SudokuHelper(grid);

        var foundCandidates = sudokuSolver.candidates(missingCell.row(), missingCell.col());

        assertArrayEquals(candidates, foundCandidates);

    }

    @Test
    @Disabled("while developing the naked pairs technique: https://www.thonky.com/sudoku/naked-pairs-triples-quads")
    void shouldFindCandidateForMissingCellInferringFromASetCoverInconsistency() {
        var sudokuSolver = new SudokuHelper(INTERMEDIATE_EXAMPLES.INTERMEDIATE_EXAMPLE_1.getPuzzle());
        var expectedCandidates = new int[]{2};

        var foundCandidates = sudokuSolver.candidates(7, 0);

        assertArrayEquals(expectedCandidates, foundCandidates);
    }

    @Test
    void shouldFindCandidateForMissingCellUsingDisjointSubsets() {
        var sudokuSolver = new SudokuHelper(INTERMEDIATE_EXAMPLE_2_PUZZLE);
        var expectedCandidates = new int[]{6};

        var foundCandidates = sudokuSolver.candidates(8, 1);

        assertArrayEquals(expectedCandidates, foundCandidates);
    }


}