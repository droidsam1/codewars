public class BattleField {
    public static boolean fieldValidator(int[][] battleField) {
        if (battleField.length != 2 || battleField[0].length != 10 || battleField[1].length != 10) {
            return false;
        }

        return false;
    }

    //TODO: this is a scaffolding method, using only while developing
    @Deprecated
    static int getNumberOfBattleships(int[][] battleField) {
        return 1;
    }
}
