package recursion;

import longest_increaseing_subset.LongestIncreasingSubsetDynamicProgramming;
import longest_increaseing_subset.LongestIncreasingSubsetRecursion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsetTest {

    @Test
    public void find_dynamically() {
        int[] ints = {2, 5, 6, 4, 2, 1, 2, 9, 8, 5};
        assertEquals(4, LongestIncreasingSubsetDynamicProgramming.find(ints));
    }

    @Test
    public void find_recursively() {
        int[] ints = {2, 5, 6, 4, 2, 1, 2, 9, 8, 5};
        assertEquals(4, LongestIncreasingSubsetRecursion.find(ints));
    }
}
