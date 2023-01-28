import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BattleFieldTest {


    @Test
    void shouldReturnFalseWhenEmptyField() {
        var battleField = new int[10][10];

        var isFieldValid = BattleField.fieldValidator(battleField);

        assertFalse(isFieldValid);
    }

    @Test
    void shouldReturnFalseWhenFieldHasIncorrectDimensions() {
        var battleField = new int[10][8];

        var isFieldValid = BattleField.fieldValidator(battleField);

        assertFalse(isFieldValid);
    }

    @Test
    void shouldContainsOnlyABattleship() {
        var battleField = new int[][] {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        var numberOfBattleships = BattleField.getNumberOfBattleships(battleField);

        assertEquals(1, numberOfBattleships);
    }

}