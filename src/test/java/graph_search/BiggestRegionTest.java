package graph_search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiggestRegionTest {

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
        BiggestRegion br = new BiggestRegion(grid);
        assertEquals(7, br.find());
    }
}
