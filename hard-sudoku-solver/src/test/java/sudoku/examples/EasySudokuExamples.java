package sudoku.examples;


/**
 * Examples taken from <a href="https://sandiway.arizona.edu/sudoku/examples.html">...</a>
 */
public class EasySudokuExamples {


    private static final int[][] EASY_EXAMPLE_1_PUZZLE = new int[][]{
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
    };
    private static final int[][] EASY_EXAMPLE_1_SOLUTION = new int[][]{
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 3, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
    };
    private static final int[][] EASY_EXAMPLE_2_PUZZLE = new int[][]{
            {1, 0, 0, 4, 8, 9, 0, 0, 6},
            {7, 3, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 1, 2, 9, 5},
            {0, 0, 7, 1, 2, 0, 6, 0, 0},
            {5, 0, 0, 7, 0, 3, 0, 0, 8},
            {0, 0, 6, 0, 9, 5, 7, 0, 0},
            {9, 1, 4, 6, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 3, 7},
            {8, 0, 0, 5, 1, 2, 0, 0, 4}
    };
    private static final int[][] EASY_EXAMPLE_2_SOLUTION = new int[][]{
            {1, 5, 2, 4, 8, 9, 3, 7, 6},
            {7, 3, 9, 2, 5, 6, 8, 4, 1},
            {4, 6, 8, 3, 7, 1, 2, 9, 5},
            {3, 8, 7, 1, 2, 4, 6, 5, 9},
            {5, 9, 1, 7, 6, 3, 4, 2, 8},
            {2, 4, 6, 8, 9, 5, 7, 1, 3},
            {9, 1, 4, 6, 3, 7, 5, 8, 2},
            {6, 2, 5, 9, 4, 8, 1, 3, 7},
            {8, 7, 3, 5, 1, 2, 9, 6, 4}
    };

    private EasySudokuExamples() {
    }

    public enum EASY_EXAMPLES {
        EASY_EXAMPLE_1(new SudokuExample(EASY_EXAMPLE_1_SOLUTION, EASY_EXAMPLE_1_PUZZLE)),//
        EASY_EXAMPLE_2(new SudokuExample(EASY_EXAMPLE_2_SOLUTION, EASY_EXAMPLE_2_PUZZLE));

        private final SudokuExample example;

        EASY_EXAMPLES(SudokuExample example) {
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
