import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BattleFieldGenerator;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BattleFieldGenerator.BOARD_SIZE;

class BoatCounterTest {

    private static int[] runTenTimes() {
        return IntStream.rangeClosed(0, BOARD_SIZE).toArray();
    }

    @ParameterizedTest
    @MethodSource("runTenTimes")
    void shouldReturnTheNumberOfBattleship(int expectedBattleship) {
        var battleField = BattleFieldGenerator.generateFieldWithNBattleships(expectedBattleship);

        var numberOfBattleships = BoatCounter.getNumberOfBattleships(battleField);

        assertEquals(expectedBattleship, numberOfBattleships);
    }

    @ParameterizedTest
    @MethodSource("runTenTimes")
    void shouldReturnTheNumberOfCruisers(int expectedCruisers) {
        var battleField = BattleFieldGenerator.generateFieldWithNCruisers(expectedCruisers);

        var numberOfBattleships = BoatCounter.getNumberOfCruisers(battleField);

        assertEquals(expectedCruisers, numberOfBattleships);
    }

}