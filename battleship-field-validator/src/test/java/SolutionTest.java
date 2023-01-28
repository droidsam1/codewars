import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private static final int[][] battleField =//
            {//
                    {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},//
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},//
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},//
                    {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},//
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//
            };

    private static final int[][] battleFieldInDiagonalContact =//
            {//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},//
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},//
                    {0, 1, 0, 0, 1, 1, 1, 0, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},//
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//
            };


    private static final int[][] valid_battlefield =//
            {//
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}//
                    , {0, 0, 0, 0, 0, 0, 0, 1, 0, 1}//
                    , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//
                    , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//
                    , {0, 0, 0, 0, 1, 0, 0, 1, 1, 0}//
                    , {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}//
                    , {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}//
                    , {0, 0, 1, 1, 1, 1, 0, 0, 0, 0}//
                    , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//
                    , {0, 0, 1, 1, 1, 0, 0, 1, 1, 1}//
            };


    private static final int[][] valid_battlefield_2 =//
            {//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},//
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},//
                    {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},//
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 1, 0, 1, 0, 0, 0, 1}//
            };

    private static final int[][] battleFieldWithInvalidBoatSize =//
            {//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},//
                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 1},//
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},//
                    {1, 0, 0, 1, 0, 1, 0, 0, 0, 1}//
            };

    @Test
    public void SampleTest() {
        assertTrue(BattleField.fieldValidator(battleField));
    }

    @Test
    public void shouldReturnFalseIfShipsAreInContact() {
        assertFalse(BattleField.fieldValidator(battleFieldInDiagonalContact));
    }

    @Test
    public void shouldReturnFalseIfShipSizeIsNotValid() {
        assertFalse(BattleField.fieldValidator(battleFieldWithInvalidBoatSize));
    }

    @Test
    public void shouldReturnTrueFromRandomTest() {
        assertTrue(BattleField.fieldValidator(valid_battlefield));
        assertTrue(BattleField.fieldValidator(valid_battlefield_2));
    }
}