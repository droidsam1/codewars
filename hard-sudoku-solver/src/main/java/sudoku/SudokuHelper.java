package sudoku;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
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
        processHiddenSingles();
        processNakedPairs();

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

    private void processNakedPairs() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nakedPairsInSubgrid(i, j);
            }
        }
    }

    private int[] getCandidatesFor(final int row, final int col) {
        if (grid[row][col] != 0) {
            return new int[]{grid[row][col]};
        }

        var candidatesSubGrid = findCandidatesInSubGrid(row, col);
        if (candidatesSubGrid.size() <= 1) {
            return toArray(candidatesSubGrid);
        }
        var candidatesInRowOrColumn = findCandidatesBasedOnRowAndColumn(row, col);

        return toArray(intersection(candidatesSubGrid, candidatesInRowOrColumn));
    }

    private void processHiddenSingles() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (candidatesGrid[i][j].length > 1) {
                    processHiddenSinglesInRowsAndCols(i, j);
                    processHiddenSinglesInSubgrid(i, j);
                }
            }
        }
    }

    private void processHiddenSinglesInRowsAndCols(final int row, final int col) {
        var candidatesInTheRow = new HashSet<Integer>();
        var candidatesInTheCol = new HashSet<Integer>();
        for (int i = 0; i < candidatesGrid.length; i++) {
            if (i != col) {
                candidatesInTheRow.addAll(Arrays.stream(candidatesGrid[row][i]).boxed().toList());
            }
            if (i != row) {
                candidatesInTheCol.addAll(Arrays.stream(candidatesGrid[i][col]).boxed().toList());
            }
        }

        var result = Arrays.stream(candidatesGrid[row][col]).boxed().toList();
        var newCandidates = result.stream().filter(i -> !candidatesInTheRow.contains(i)).toList();
        if (newCandidates.size() == 1) {
            candidatesGrid[row][col] = new int[]{newCandidates.get(0)};
        } else {
            newCandidates = result.stream().filter(i -> !candidatesInTheCol.contains(i)).toList();
            if (newCandidates.size() == 1) {
                candidatesGrid[row][col] = new int[]{newCandidates.get(0)};
            }
        }
    }

    private void processHiddenSinglesInSubgrid(final int row, final int col) {
        var candidatesInGrid = new HashSet<Integer>();

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < ((col / 3) * 3) + 3; j++) {
                if (i != row && j != col) {
                    var candidatesForCell = candidatesGrid[i][j];
                    candidatesInGrid.addAll(Arrays.stream(candidatesForCell).boxed().toList());
                }
            }
        }

        var result = Arrays.stream(candidatesGrid[row][col]).boxed().toList();
        var newCandidates = result.stream().filter(i -> !candidatesInGrid.contains(i)).toList();
        if (newCandidates.size() == 1) {
            candidatesGrid[row][col] = new int[]{newCandidates.get(0)};
        }
    }


    public int[] candidates(final int row, final int col) {
        return candidatesGrid[row][col];
    }

    private void nakedPairsInSubgrid(final int row, final int col) {
        var nakedPairs = new HashMap<NakedPair, Integer>();

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < ((col / 3) * 3) + 3; j++) {
                var candidatesForCell = candidatesGrid[i][j];
                if (candidatesForCell.length == 2) {
                    var nakedPair = new NakedPair(candidatesForCell[0], candidatesForCell[1]);
                    nakedPairs.put(nakedPair, nakedPairs.getOrDefault(nakedPair, 0) + 1);
                }
            }
        }
        for (var entry : nakedPairs.entrySet()) {
            if (entry.getValue() == 2) {
                removeNakedPairFromOthersCandidatesInSubgrid(row, col, entry.getKey());
            }
        }

    }

    private void removeNakedPairFromOthersCandidatesInSubgrid(final int row, final int col, NakedPair nakedPair) {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < ((col / 3) * 3) + 3; j++) {
                var candidatesForCell = candidatesGrid[i][j];
                if (candidatesForCell.length >= 2 && (candidatesForCell[0] != nakedPair.candidate() || candidatesForCell[1] != nakedPair.anotherCandidate())) {
                    candidatesGrid[i][j] = Arrays.stream(candidatesForCell)
                                                 .filter(value -> value != nakedPair.candidate() && value != nakedPair.anotherCandidate())
                                                 .toArray();
                }
            }

        }
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

    private record NakedPair(int candidate, int anotherCandidate) {

    }

}
