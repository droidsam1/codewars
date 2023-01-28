import domain.BoatType;

import java.util.HashMap;
import java.util.Map;

public class BoatCounter {

    static int getNumberOfBattleships(int[][] battleField) {
        return getNumberOf(battleField, BoatType.BATTLESHIP);
    }

    static int getNumberOfCruisers(int[][] battleField) {
        return getNumberOf(battleField, BoatType.CRUISER);
    }

    private static int getNumberOf(int[][] battleField, BoatType boatType) {

        Map<BoatType, Integer> boats = new HashMap<>();
        for (int i = 0; i < battleField.length; i++) {
            var occupiedCellsInThisRow = 0;
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == 1) {
                    occupiedCellsInThisRow++;
                } else if (occupiedCellsInThisRow != 0) {
                    var boat = BoatType.ofSize(occupiedCellsInThisRow);
                    boats.put(boat, boats.getOrDefault(boat, 0) + 1);
                    occupiedCellsInThisRow = 0;
                }
            }

        }

        return boats.getOrDefault(boatType, 0);
    }

    static int getNumberOfDestroyers(int[][] battleField) {
        return getNumberOf(battleField, BoatType.DESTROYER);
    }

    public static int getNumberOfSubmarines(int[][] battleField) {
        return getNumberOf(battleField, BoatType.SUBMARINE);
    }
}
