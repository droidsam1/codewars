import org.junit.jupiter.api.Test;
import utils.BattleFieldGenerator;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void shouldFailIfContainsMoreThanOneBattleship() {
        var battleField = BattleFieldGenerator.withOnlyTwoBattleship();

        var isFieldValid = BattleField.fieldValidator(battleField);

        assertFalse(isFieldValid);
    }


}