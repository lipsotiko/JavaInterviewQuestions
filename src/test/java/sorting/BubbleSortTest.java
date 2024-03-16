package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void test() {
        int[] sorted = bubbleSort.sort(new int[]{33, 24, 2, 45, 6, 10, 23, 100, 33});
        int[] expected = new int[]{
                2,
                6,
                10,
                23,
                24,
                33,
                33,
                45,
                100
        };
        for (int i = 0; i < sorted.length; i++) {
            assertEquals(expected[i], sorted[i]);
        }
    }
}
