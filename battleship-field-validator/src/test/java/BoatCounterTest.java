import domain.BoatType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BattleFieldGenerator;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BattleFieldGenerator.BOARD_SIZE;

class BoatCounterTest {

    private static Stream<? extends Arguments> runTenTimesForEachBoatType() {
        return Arrays.stream(BoatType.values()).flatMap(boatType -> generateTenExpectedNumber(boatType));
    }

    private static Stream<Arguments> generateTenExpectedNumber(BoatType boatType) {
        return IntStream.rangeClosed(0, BOARD_SIZE / 2).mapToObj(i -> Arguments.of(boatType, i));
    }

    @ParameterizedTest
    @MethodSource("runTenTimesForEachBoatType")
    void shouldReturnTheNumberOf(BoatType boatType, int expectedBoats) {
        var battleField = BattleFieldGenerator.generateFieldWithNBoats(expectedBoats, boatType);

        var numberOfBattleships = BoatCounter.getNumberOf(battleField, boatType);

        assertEquals(expectedBoats, numberOfBattleships);
    }

}