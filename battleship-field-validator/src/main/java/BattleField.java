import domain.BoatType;

import java.util.Arrays;

public class BattleField {
    public static boolean fieldValidator(int[][] battleField) {
        if (battleField.length != 10 || Arrays.stream(battleField).anyMatch(row -> row.length != 10) || Arrays.stream(battleField).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell == 0))) {
            return false;
        }

        var boats = BoatCounter.getBoats(battleField);

        var numberOfBattleships = boats.getOrDefault(BoatType.BATTLESHIP, 0);
        var numberOfCruisers = boats.getOrDefault(BoatType.CRUISER, 0);
        var numberOfDestroyers = boats.getOrDefault(BoatType.DESTROYER, 0);
        var numberOfSubmarines = boats.getOrDefault(BoatType.SUBMARINE, 0);

        return numberOfBattleships == 1 && numberOfCruisers == 2 && numberOfDestroyers == 3 && numberOfSubmarines == 4;
    }

}
