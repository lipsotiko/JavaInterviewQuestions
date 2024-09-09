package graph_search;

import org.junit.Assert;
import org.junit.Test;

public class MineForGoldTest {

    private final MineForGold sln = new MineForGold();

    @Test
    public void testFindGreatestPathForDiggingGold() {
        int[][] mine = {
                { 0, 1, 2, 3},
                { 1, 2, 3, 0},
                { 2, 3, 0, 1},
                { 3, 0, 1, 2}
        };
        Assert.assertEquals(18, sln.findGreatestPathForDiggingGold(mine));

        int[][] mine2 = {
                { 0, 0, 0, 3},
                { 1, 0, 0, 1},
                { 2, 0, 0, 1},
                { 3, 0, 0, 2}
        };
        Assert.assertEquals(7, sln.findGreatestPathForDiggingGold(mine2));

        int[][] mine3 = {
                { 0 }
        };
        Assert.assertEquals(0, sln.findGreatestPathForDiggingGold(mine3));

        int[][] mine4 = {};
        Assert.assertEquals(0, sln.findGreatestPathForDiggingGold(mine4));

        int[][] mine5 = null;
        Assert.assertEquals(0, sln.findGreatestPathForDiggingGold(mine5));
    }
}
