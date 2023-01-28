package utils;

import java.util.Random;
import java.util.stream.IntStream;

public class BattleFieldGenerator {
    public static int[][] withOnlyOneBattleship() {
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

    public static int[][] withOnlyTwoBattleship() {
        var field = new int[10][10];
        var maxBattleshipsInTheField = 2;
        var numberOfBattleships = 0;
        for (int i = 0; i < 10; i++) {
            var putABattleshipInThisRow = new Random().nextBoolean();
            if (!putABattleshipInThisRow) {
                field[i] = IntStream.generate(() -> 0).limit(10).toArray();
                continue;
            }
            if (numberOfBattleships < maxBattleshipsInTheField) {
                numberOfBattleships++;
                var startingPoint = new Random().nextInt(10 - 4);
                var endingPoint = startingPoint + 4;
                for (int j = 0; j < 10; j++) {
                    if (j >= startingPoint && j <= endingPoint) {
                        field[i][j] = 1;
                    } else {
                        field[i][j] = 0;
                    }
                }
            }

        }
        return field;
    }

    public static int[][] withInvalidDimensions() {
        return new int[new Random().nextInt(9)][new Random().nextInt(9)];
    }

    public static int[][] emptyField() {
        return new int[10][10];
    }
}
