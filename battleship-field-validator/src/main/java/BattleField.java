import domain.BoatType;
import domain.InvalidBoatSize;

import java.util.Arrays;
import java.util.Map;

public class BattleField {

    public static boolean fieldValidator(int[][] battleField) {
        if (!hasValidSize(battleField) || isEmpty(battleField)) {
            return false;
        }
        var boats = countBoatsIn(battleField);

        var numberOfBattleships = boats.getOrDefault(BoatType.BATTLESHIP, 0);
        var numberOfCruisers = boats.getOrDefault(BoatType.CRUISER, 0);
        var numberOfDestroyers = boats.getOrDefault(BoatType.DESTROYER, 0);
        var numberOfSubmarines = boats.getOrDefault(BoatType.SUBMARINE, 0);

        return numberOfBattleships == 1 && numberOfCruisers == 2 && numberOfDestroyers == 3 && numberOfSubmarines == 4;
    }

    private static boolean isEmpty(int[][] battleField) {
        return Arrays.stream(battleField).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell == 0));
    }

    private static boolean hasValidSize(int[][] battleField) {
        return battleField.length == 10 && Arrays.stream(battleField).anyMatch(row -> row.length == 10);
    }

    private static Map<BoatType, Integer> countBoatsIn(int[][] battleField) {
        try {
            return BoatCounter.getBoats(battleField);
        } catch (InvalidBoatSize ex) {
            return Map.of();
        }
    }

}
