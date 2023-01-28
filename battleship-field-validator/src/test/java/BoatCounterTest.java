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

        var numberOfCruisers = BoatCounter.getNumberOfCruisers(battleField);

        assertEquals(expectedCruisers, numberOfCruisers);
    }

    @ParameterizedTest
    @MethodSource("runTenTimes")
    void shouldReturnTheNumberOfDestroyers(int expectedDestroyers) {
        var battleField = BattleFieldGenerator.generateFieldWithNDestroyers(expectedDestroyers);

        var numberOfDestroyers = BoatCounter.getNumberOfDestroyers(battleField);

        assertEquals(expectedDestroyers, numberOfDestroyers);
    }

    @ParameterizedTest
    @MethodSource("runTenTimes")
    void shouldReturnTheNumberOfSubmarines(int expectedSubmarines) {
        var battleField = BattleFieldGenerator.generateFieldWithNSubmarines(expectedSubmarines);

        var numberOfBattleships = BoatCounter.getNumberOfSubmarines(battleField);

        assertEquals(expectedSubmarines, numberOfBattleships);
    }

}