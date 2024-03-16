package arrays;

import org.junit.jupiter.api.Test;

import static arrays.TwoSum.twoSum;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    @Test
    public void firstTwoSummedTest() {
        assertArrayEquals(twoSum(new int[] {1, 9, 13, 20, 47}, 10), new int[] {0, 1});
    }

    @Test
    public void firstAndLastSummedTest() {
        assertArrayEquals(twoSum(new int[] {3, 2, 4, 1, 9}, 12), new int[] {0, 4});
    }

    @Test
    public void emptyArrayTest() {
        assertArrayEquals(twoSum(new int[] { }, 10), new int[] { });
    }

    @Test
    public void sameIndex() {
        assertArrayEquals(twoSum(new int[] {13, 20, 5, 5, 47}, 10), new int[] {2, 3});
    }

}
