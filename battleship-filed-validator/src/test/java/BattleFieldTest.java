import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleFieldTest {


    @Test
    void shouldReturnFalseWhenEmptyField() {
        var battleField = BattleFieldGenerator.emptyField();

        var isFieldValid = BattleField.fieldValidator(battleField);

        assertFalse(isFieldValid);
    }

    @Test
    void shouldReturnFalseWhenFieldHasIncorrectDimensions() {
        var battleField = BattleFieldGenerator.withInvalidDimensions();

        var isFieldValid = BattleField.fieldValidator(battleField);

        assertFalse(isFieldValid);
    }

    @Test
    void shouldContainsOnlyABattleship() {
        var battleField = BattleFieldGenerator.withOnlyOneBattleship();

        var numberOfBattleships = BattleField.getNumberOfBattleships(battleField);
        assertEquals(1, numberOfBattleships);

        var isFieldValid = BattleField.fieldValidator(battleField);
        assertTrue(isFieldValid);
    }


}