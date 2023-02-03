import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SnailTest {


    @Test
    void shouldEmptyMatrixBeSorted() {
        int[][] input = {{}};
        int[] expectedOutput = {};

        test(input, expectedOutput);
    }

    @Test
    void should1x1MatrixBeSorted() {
        int[][] input = {{1}};
        int[] expectedOutput = {1};

        test(input, expectedOutput);
    }

    @Test
    void should2x2MatrixBeSorted() {
        int[][] input = {{1, 2}, {3, 4}};
        int[] expectedOutput = {1, 2, 4, 3};

        test(input, expectedOutput);
    }


    @Test
    @Disabled
    void SnailTest1() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    private String int2dToString(int[][] a) {
        return Arrays.stream(a).map(Arrays::toString).collect(joining("\n"));
    }

    private void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        assertArrayEquals(result, Snail.snail(array));
    }

}