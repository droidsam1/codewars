package sudoku;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuHelper {

    private final int[][] grid;

    public SudokuHelper(int[][] grid) {
        this.grid = grid;
    }

    public int[] candidatesInRowColumn(final int row) {
        var presentNumbersRow = new HashSet<Integer>();
        for (int i = 0; i < grid.length; i++) {
            presentNumbersRow.add(grid[row][i]);
            presentNumbersRow.add(grid[i][row]);
        }

        return toArray(difference(IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toSet()), presentNumbersRow));
    }

    private int[] toArray(Collection<Integer> collection) {
        return collection.stream().mapToInt(i -> i).toArray();
    }

    private <T> Set<T> difference(final Set<T> setOne, final Set<T> setTwo) {
        Set<T> result = new HashSet<>(setOne);
        result.removeAll(setTwo);
        return result;
    }

}
