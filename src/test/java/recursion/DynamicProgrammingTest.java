package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTest {

    private DynamicProgramming dp;

    @BeforeEach
    public void set_up() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        dp = new DynamicProgramming(grid);
    }

    @Test
    public void test_count_the_paths_with_recursion() {

        assertEquals(27, dp.countPathsWithRecursion(0, 0, 7, 7));
    }

    @Test
    public void test_count_the_paths_with_dynamic_programming() {
        assertEquals(27, dp.countPathsWithDynamicProgramming(0, 0, 7, 7));
    }

}
