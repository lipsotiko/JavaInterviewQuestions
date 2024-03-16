package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTest {

    private final BinarySearch bs = new BinarySearch();

    int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    @Test
    public void test_recursive() {
        for(int i : numbers) {
            assertTrue(bs.recursiveSearch(numbers, i));
        }
        assertFalse(bs.recursiveSearch(numbers, 1));
        assertFalse(bs.recursiveSearch(numbers, 100));
    }

    @Test
    public void test_iterative() {
        for(int i : numbers) {
            assertTrue(bs.iterativeSearch(numbers, i));
        }
        assertFalse(bs.iterativeSearch(numbers, 1));
        assertFalse(bs.iterativeSearch(numbers, 100));
    }
}
