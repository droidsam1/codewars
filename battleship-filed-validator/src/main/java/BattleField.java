import java.util.Arrays;

public class BattleField {
    public static boolean fieldValidator(int[][] battleField) {
        if (battleField.length != 10 || Arrays.stream(battleField).anyMatch(row -> row.length != 10)) {
            return false;
        }

        return true;
    }

    //TODO: this is a scaffolding method, using only while developing
    @Deprecated
    static int getNumberOfBattleships(int[][] battleField) {
        return 1;
    }
}
