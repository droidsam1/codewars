public class BoatCounter {

    public static final int BATTLESHIP_SIZE = 4;

    static int getNumberOfBattleships(int[][] battleField) {

        var occupiedCells = 0;
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == 1) {
                    occupiedCells++;
                }
            }

        }

        return occupiedCells / BATTLESHIP_SIZE;
    }
}
