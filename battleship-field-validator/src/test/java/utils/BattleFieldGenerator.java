package utils;

import domain.BoatType;

import java.util.Random;

import static domain.BoatType.BATTLESHIP;

public class BattleFieldGenerator {

    public static final int BOARD_SIZE = 10;

    public static int[][] withOnlyOneBattleship() {
        return generateFieldWithNBattleships(1);

    }

    public static int[][] withOnlyTwoBattleship() {
        return generateFieldWithNBattleships(2);
    }

    public static int[][] generateFieldWithNBattleships(int numberOfBattleships) {
        return generateFieldWithNBoats(numberOfBattleships, BATTLESHIP);
    }

    public static int[][] generateFieldWithNBoats(int numberOfBoats, BoatType boatType) {
        assert (numberOfBoats <= BOARD_SIZE / 2);//ships cannot be in contact, so this impl leaves a row in between

        var boatSize = boatType.getSize();
        var field = new int[BOARD_SIZE][BOARD_SIZE];
        var numberOfBattleships = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            var putABattleshipInThisRow = i % 2 == 0; //leave a row between ships
            if (putABattleshipInThisRow && numberOfBattleships < numberOfBoats) {
                numberOfBattleships++;
                var startingPoint = new Random().nextInt(BOARD_SIZE - boatSize);
                var endingPoint = startingPoint + boatSize - 1;
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (j >= startingPoint && j <= endingPoint) {
                        field[i][j] = 1;
                    }
                }
            }

        }
        return field;
    }

    public static int[][] generateFieldWithNBoatsInCols(int numberOfBoats, BoatType boatType) {
        assert (numberOfBoats <= BOARD_SIZE / 2);//ships cannot be in contact, so this impl leaves a row in between

        var boatSize = boatType.getSize();
        var field = new int[BOARD_SIZE][BOARD_SIZE];
        var numberOfBattleships = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            var putABattleshipInThisCol = i % 2 == 0; //leave a row between ships
            if (putABattleshipInThisCol && numberOfBattleships < numberOfBoats) {
                numberOfBattleships++;
                var startingPoint = new Random().nextInt(BOARD_SIZE - boatSize);
                var endingPoint = startingPoint + boatSize - 1;
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (j >= startingPoint && j <= endingPoint) {
                        field[j][i] = 1;
                    }
                }
            }

        }
        return field;
    }

    public static int[][] withInvalidDimensions() {
        return new int[new Random().nextInt(BOARD_SIZE - 1)][new Random().nextInt(BOARD_SIZE - 1)];
    }

    public static int[][] emptyField() {
        return new int[BOARD_SIZE][BOARD_SIZE];
    }

}
