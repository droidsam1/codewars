import domain.BoatType;

import java.util.HashMap;
import java.util.Map;

public class BoatCounter {

    public static int getNumberOf(int[][] battleField, BoatType boatType) {

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

        for (int i = 0; i < battleField.length; i++) {
            var occupiedCellsInThisCol = 0;
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[j][i] == 1) {
                    occupiedCellsInThisCol++;
                } else if (occupiedCellsInThisCol == 1) {
                    occupiedCellsInThisCol = 0;
                } else if (occupiedCellsInThisCol > 1) {
                    var boat = BoatType.ofSize(occupiedCellsInThisCol);
                    boats.put(boat, boats.getOrDefault(boat, 0) + 1);
                    occupiedCellsInThisCol = 0;
                }
            }
        }
        return boats.getOrDefault(boatType, 0);
    }
}
