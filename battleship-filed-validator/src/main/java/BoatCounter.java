public class BoatCounter {
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
