package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    public void test() {
        int[] sorted = quickSort.sort(new int[]{33, 24, 2, 45, 6, 10, 23, 100, 33});
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
