package sudoku;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SudokuHelper {

    private final int[][] grid;

    public SudokuHelper(int[][] grid) {
        this.grid = grid;
    }

    public int[] candidatesInRowColumn(final int row, final int col) {
        return toArray(findCandidatesBasedOnRowAndColumn(row, col));
    }

    private Set<Integer> findCandidatesBasedOnRowAndColumn(final int row, final int col) {
        var presentNumbersRow = new HashSet<Integer>();
        for (int i = 0; i < grid.length; i++) {
            presentNumbersRow.add(grid[row][i]);
            presentNumbersRow.add(grid[i][col]);
        }

        return difference(IntStream.rangeClosed(0, 9).boxed().collect(toSet()), presentNumbersRow);
    }


    public int[] findCandidatesForCellInItsOwnSubgrid(int row, int col) {
        return toArray(findCandidatesInSubGrid(row, col));
    }

    private Set<Integer> findCandidatesInSubGrid(int row, int col) {
        var alreadyPresentNumbers = new HashSet<Integer>();

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < ((col / 3) * 3) + 3; j++) {
                alreadyPresentNumbers.add(grid[i][j]);
            }
        }

        return difference(IntStream.rangeClosed(0, 9).boxed().collect(toSet()), alreadyPresentNumbers);
    }

    private int[] toArray(Collection<Integer> collection) {
        return collection.stream().mapToInt(i -> i).toArray();
    }

    private <T> Set<T> difference(final Set<T> setOne, final Set<T> setTwo) {
        Set<T> result = new HashSet<>(setOne);
        setTwo.stream().filter(Predicate.not(result::add)).forEach(result::remove);
        return result;
    }

}
