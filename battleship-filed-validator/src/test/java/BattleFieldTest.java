import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BattleFieldTest {


    @Test
    void shouldReturnFalseWhenEmptyField() {
        var input = new int[10][10];

        var isFieldValid = BattleField.fieldValidator(input);

        assertFalse(isFieldValid);
    }

}