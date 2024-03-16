package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortedArraysTest {

    @Test
    public void test_1() {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        mergeSortedArrays.merge(nums1, 3, new int[] {2, 5, 6}, 3);

        int[] expected = {1, 2, 2, 3, 5, 6};
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void test_2() {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] nums1 = {0};
        mergeSortedArrays.merge(nums1, 0, new int[] {1}, 1);

        int[] expected = {1};
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void test_3() {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] nums1 = {1};
        mergeSortedArrays.merge(nums1, 1, new int[] {}, 0);

        int[] expected = {1};
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void test_4() {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] nums1 = {2, 0};
        mergeSortedArrays.merge(nums1, 1, new int[] {1}, 1);

        int[] expected = {1, 2};
        assertArrayEquals(expected, nums1);
    }


}