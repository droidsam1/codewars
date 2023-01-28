import domain.BoatType;

import java.util.HashMap;
import java.util.Map;

public class BoatCounter {

    public static int getNumberOf(int[][] battleField, BoatType boatType) {
        return getBoats(battleField).getOrDefault(boatType, 0);
    }

    public static Map<BoatType, Integer> getBoats(int[][] battleField) {
        var ships = getShipsInRows(battleField);
        getShipsInCols(battleField).forEach((k, v) -> ships.merge(k, v, Integer::sum));
        getSubmarines(battleField).forEach((k, v) -> ships.merge(k, v, Integer::sum));
        return ships;
    }

    private static Map<BoatType, Integer> getShipsInCols(int[][] battleField) {
        Map<BoatType, Integer> ships = new HashMap<>();
        for (int i = 0; i < battleField.length; i++) {
            var occupiedCellsInThisCol = 0;
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[j][i] == 1) {
                    if (isSurroundedByWaterLeftRight(j, i, battleField)) {
                        occupiedCellsInThisCol++;
                    }
                } else if (occupiedCellsInThisCol == 1) {
                    occupiedCellsInThisCol = 0;
                } else if (occupiedCellsInThisCol > 1) {
                    var ship = BoatType.ofSize(occupiedCellsInThisCol);
                    ships.put(ship, ships.getOrDefault(ship, 0) + 1);
                    occupiedCellsInThisCol = 0;
                }
            }
        }
        return ships;
    }

    private static Map<BoatType, Integer> getShipsInRows(int[][] battleField) {
        Map<BoatType, Integer> ships = new HashMap<>();
        for (int i = 0; i < battleField.length; i++) {
            var occupiedCellsInThisRow = 0;
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == 1) {
                    if (isSurroundedByWaterUpDown(i, j, battleField)) {
                        occupiedCellsInThisRow++;
                    }
                } else if (occupiedCellsInThisRow == 1) {
                    occupiedCellsInThisRow = 0;
                } else if (occupiedCellsInThisRow != 0) {
                    var ship = BoatType.ofSize(occupiedCellsInThisRow);
                    ships.put(ship, ships.getOrDefault(ship, 0) + 1);
                    occupiedCellsInThisRow = 0;
                }
            }
        }
        return ships;
    }

    private static boolean isSurroundedByWaterUpDown(int i, int j, int[][] battleField) {
        var previousRow = i - 1;
        var nextRow = i + 1;
        var isSurroundedByWater = true;
        if (previousRow >= 0) {
            isSurroundedByWater = battleField[previousRow][j] == 0;
        }
        if (nextRow < battleField[i].length) {
            isSurroundedByWater &= battleField[nextRow][j] == 0;
        }
        return isSurroundedByWater;
    }

    private static boolean isSurroundedByWaterLeftRight(int i, int j, int[][] battleField) {
        var previousCol = j - 1;
        var nextCol = j + 1;
        var isSurroundedByWater = true;
        if (previousCol >= 0) {
            isSurroundedByWater = battleField[i][previousCol] == 0;
        }
        if (nextCol < battleField[i].length) {
            isSurroundedByWater &= battleField[i][nextCol] == 0;
        }
        return isSurroundedByWater;
    }

    private static Map<BoatType, Integer> getSubmarines(int[][] battleField) {
        Map<BoatType, Integer> ships = new HashMap<>();
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == 1) {
                    if (isSurroundedByWaterLeftRight(i, j, battleField) && isSurroundedByWaterUpDown(i, j, battleField)) {
                        ships.put(BoatType.SUBMARINE, ships.getOrDefault(BoatType.SUBMARINE, 0) + 1);
                    }
                }
            }
        }
        return ships;
    }
}


