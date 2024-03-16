package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopDownMergeSortTest {

    private final TopDownMergeSort topDownMergeSort = new TopDownMergeSort();

    @Test
    public void test() {
        int[] sorted = topDownMergeSort.mergesort(new int[]{33, 24, 2, 45, 6, 10, 23, 100, 33});
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
