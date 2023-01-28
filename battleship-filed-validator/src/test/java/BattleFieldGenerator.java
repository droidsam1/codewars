import java.util.Random;

public class BattleFieldGenerator {
    static int[][] getBattleFieldWithOnlyOneBattleship() {
        return new int[][]{ {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }

    static int[][] withInvalidDimensions() {
        return new int[new Random().nextInt(9)][new Random().nextInt(9)];
    }

    static int[][] emptyField() {
        return new int[10][10];
    }
}
