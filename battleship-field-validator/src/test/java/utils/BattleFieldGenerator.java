package utils;

import java.util.Random;
import java.util.stream.IntStream;

public class BattleFieldGenerator {

    public static final int BOARD_SIZE = 10;
    public static final int BATTLESHIP_SIZE = 4;

    public static int[][] withOnlyOneBattleship() {
        return generateFieldWithNBattleships(1);

    }

    public static int[][] withOnlyTwoBattleship() {
        return generateFieldWithNBattleships(2);
    }

    public static int[][] generateFieldWithNBattleships(int maxBattleshipsInTheField) {
        var field = new int[BOARD_SIZE][BOARD_SIZE];
        var numberOfBattleships = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            var putABattleshipInThisRow = new Random().nextBoolean();
            var maxRowsThatCanBeEmpty = BOARD_SIZE - maxBattleshipsInTheField;
            if (!putABattleshipInThisRow && i < maxRowsThatCanBeEmpty) {
                field[i] = IntStream.generate(() -> 0).limit(BOARD_SIZE).toArray();
                continue;
            }
            if (numberOfBattleships < maxBattleshipsInTheField) {
                numberOfBattleships++;
                var startingPoint = new Random().nextInt(BOARD_SIZE - BATTLESHIP_SIZE);
                var endingPoint = startingPoint + BATTLESHIP_SIZE -1;
                for (int j = 0; j < BOARD_SIZE; j++) {
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
        return new int[BOARD_SIZE][BOARD_SIZE];
    }
}
