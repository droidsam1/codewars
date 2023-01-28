import domain.BoatType;

import java.util.Arrays;

public class BattleField {
    public static boolean fieldValidator(int[][] battleField) {
        if (battleField.length != 10 || Arrays.stream(battleField).anyMatch(row -> row.length != 10) || Arrays.stream(battleField).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell == 0))) {
            return false;
        }

        return BoatCounter.getNumberOf(battleField, BoatType.BATTLESHIP) == 1;
    }

}
