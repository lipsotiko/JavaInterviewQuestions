package graph_search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDistinctRegionsTest {
    int[][] grid = {
            {0,0,0,1,1,0,0},
            {0,1,0,0,1,1,0},
            {1,1,0,1,0,0,1},
            {0,0,0,0,0,1,0},
            {1,1,0,0,0,0,0},
            {0,0,0,1,0,0,0}
    };

    @Test
    public void finds_biggest_region() {
        CountDistinctRegions dr = new CountDistinctRegions(grid);
        assertEquals(4, dr.count());
    }
}