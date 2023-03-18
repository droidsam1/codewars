package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class KataTest {

    @Test void shouldReturnTwoPoints() {
        var inputPoints = List.of(new Point(2, 2), new Point(1, 1));
        var expected = List.of(new Point(2, 2), new Point(1, 1));

        var result = Kata.closestPair(inputPoints);

        verify(expected, result);
    }


    @Test @Disabled("while developing with TDD") void test01_Example() {

        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(6, 3), new Point(7, 4));
        verify(expected, result);
    }

    @Test @Disabled("while developing with TDD") void test02_TwoPoints() {

        List<Point> points = Arrays.asList(new Point(2, 2), new Point(6, 3));

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(6, 3), new Point(2, 2));
        verify(expected, result);
    }

    @Test @Disabled("while developing with TDD") void test03_DuplicatedPoint() {

        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(5, 5), new Point(5, 5));
        verify(expected, result);
    }

    private void verify(List<Point> expected, List<Point> actual) {
        Comparator<Point> comparator = Comparator.comparingDouble(p -> p.x);

        assertNotNull(actual, "Returned array cannot be null.");
        assertEquals(2, actual.size(), "Expected exactly two points.");
        assertFalse(actual.get(0) == null || actual.get(1) == null, "Returned points must not be null.");

        assertTrue(
                expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected),
                String.format("Expected: %s, Actual: %s", expected, actual)
        );
    }
}

