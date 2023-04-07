package sudoku.examples;


/**
 * Examples taken from <a href="https://sandiway.arizona.edu/sudoku/examples.html">...</a>
 */
public class IntermediateSudokuExamples {


    private static final int[][] INTERMEDIATE_EXAMPLE_1_PUZZLE = new int[][]{
            {0, 2, 0, 6, 0, 8, 0, 0, 0},
            {5, 8, 0, 0, 0, 9, 7, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 0},
            {3, 7, 0, 0, 0, 0, 5, 0, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 8, 0, 0, 0, 0, 1, 3},
            {0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 9, 8, 0, 0, 0, 3, 6},
            {0, 0, 0, 3, 0, 6, 0, 9, 0}
    };
    private static final int[][] INTERMEDIATE_EXAMPLE_1_SOLUTION = new int[][]{
            {1, 2, 3, 6, 7, 8, 9, 4, 5},
            {5, 8, 4, 2, 3, 9, 7, 6, 1},
            {9, 6, 7, 1, 4, 5, 3, 2, 8},
            {3, 7, 2, 4, 6, 1, 5, 8, 9},
            {6, 9, 1, 5, 8, 3, 2, 7, 4},
            {4, 5, 8, 7, 9, 2, 6, 1, 3},
            {8, 3, 6, 9, 2, 4, 1, 5, 7},
            {2, 1, 9, 8, 5, 7, 4, 3, 6},
            {7, 4, 5, 3, 1, 6, 8, 9, 2}
    };

    private IntermediateSudokuExamples() {
    }

    public enum INTERMEDIATE_EXAMPLES {
        INTERMEDIATE_EXAMPLE_1(new SudokuExample(INTERMEDIATE_EXAMPLE_1_SOLUTION, INTERMEDIATE_EXAMPLE_1_PUZZLE));//

        private final SudokuExample example;

        INTERMEDIATE_EXAMPLES(SudokuExample example) {
            this.example = example;
        }

        public SudokuExample getExample() {
            return example;
        }

        public int[][] getPuzzle() {
            return example.puzzle();
        }

        public int[][] getSolution() {
            return example.solution();
        }
    }

}
