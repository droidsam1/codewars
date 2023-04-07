package sudoku;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuHelper {

    private final int[][] grid;
    private final int[][][] candidatesGrid;

    public SudokuHelper(int[][] grid) {
        this.grid = grid;
        this.candidatesGrid = buildCandidatesGrid();
    }

    private int[][][] buildCandidatesGrid() {
        var candidates = new int[grid.length][grid.length][];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                candidates[i][j] = getCandidatesFor(i, j);
            }
        }
        return candidates;
    }


    public int[] getCandidatesFor(final int row, final int col) {
        if(grid[row][col] != 0){
            return new int[]{grid[row][col]};
        }

        var candidatesSubGrid = findCandidatesInSubGrid(row, col);
        if (candidatesSubGrid.size() <= 1) {
            return toArray(candidatesSubGrid);
        }
        var candidatesInRowOrColumn = findCandidatesBasedOnRowAndColumn(row, col);

        return toArray(intersection(candidatesSubGrid, candidatesInRowOrColumn));
    }

    public int[] candidates(final int row, final int col) {
        return candidatesGrid[row][col];
    }


    private <T> Set<T> intersection(Set<T> setOne, Set<T> setTwo) {
        return setOne.stream().filter(setTwo::contains).collect(Collectors.toSet());
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
