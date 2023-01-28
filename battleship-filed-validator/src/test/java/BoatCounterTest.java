import org.junit.jupiter.api.Test;
import utils.BattleFieldGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoatCounterTest {

    @Test
    void shouldReturnOneWhenThereIsOnlyOneBattleship() {
        var battleField = BattleFieldGenerator.withOnlyOneBattleship();

        var numberOfBattleships = BoatCounter.getNumberOfBattleships(battleField);
        assertEquals(1, numberOfBattleships);
    }

    @Test
    void shouldReturnTwoWhenThereIsTwoBattleship() {
        var battleField = BattleFieldGenerator.withOnlyTwoBattleship();

        var numberOfBattleships = BoatCounter.getNumberOfBattleships(battleField);
        assertEquals(2, numberOfBattleships);
    }


}