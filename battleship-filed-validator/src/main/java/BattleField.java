import java.util.Arrays;

public class BattleField {
    public static boolean fieldValidator(int[][] battleField) {
        if (battleField.length != 10 || Arrays.stream(battleField).anyMatch(row -> row.length != 10) || Arrays.stream(battleField).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell == 0))) {
            return false;
        }

        return getNumberOfBattleships(battleField) == 1;
    }

    //TODO: this is a scaffolding method, using only while developing
    @Deprecated
    static int getNumberOfBattleships(int[][] battleField) {

        var occupiedCells = 0;
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == 1) {
                    occupiedCells++;
                }
            }

        }

        var battleshipSize = 4;
        return occupiedCells / battleshipSize;
    }
}
