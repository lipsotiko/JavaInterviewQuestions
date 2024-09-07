package graph_search;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountPathsTest {

    int[][] grid = {
            {1,1,1,1,1,1,1,1},
            {1,1,0,1,1,1,0,1},
            {1,1,1,1,0,1,1,1},
            {0,1,0,1,1,0,1,1},
            {1,1,0,1,1,1,1,1},
            {1,1,1,0,0,1,0,1},
            {1,0,1,1,1,0,1,1},
            {1,1,1,1,1,1,1,1},
    };

    @Test
    public void count_paths() {
        CountPaths cp = new CountPaths(grid);
        assertEquals(27, cp.run());
    }

    @Test
    public void count_paths_with_memoization() {
        CountPaths cp = new CountPaths(grid);
        assertEquals(27, cp.runWithMemoization());
    }

}
