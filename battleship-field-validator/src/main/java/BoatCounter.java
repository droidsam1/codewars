import domain.BoatType;

import java.util.HashMap;
import java.util.Map;

public class BoatCounter {

    public static int getNumberOf(int[][] battleField, BoatType boatType) {
        var ships = getShipsInRows(battleField);
        ships.putAll(getShipsInCols(battleField));
        return ships.getOrDefault(boatType, 0);
    }

    private static Map<BoatType, Integer> getShipsInCols(int[][] battleField) {
        Map<BoatType, Integer> ships = new HashMap<>();
        for (int i = 0; i < battleField.length; i++) {
            var occupiedCellsInThisCol = 0;
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[j][i] == 1) {
                    occupiedCellsInThisCol++;
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
                    occupiedCellsInThisRow++;
                } else if (occupiedCellsInThisRow != 0) {
                    var ship = BoatType.ofSize(occupiedCellsInThisRow);
                    ships.put(ship, ships.getOrDefault(ship, 0) + 1);
                    occupiedCellsInThisRow = 0;
                }
            }
        }
        return ships;
    }
}
