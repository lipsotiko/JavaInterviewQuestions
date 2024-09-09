package graph_search;

import junit.framework.TestCase;

public class LargestXTest extends TestCase {

    public void testSingleCellX() {
        int[][] matrix = new int[][] {
                {0, 0, 0,},
                {0, 1, 0,},
                {0, 0, 0,},
        };

        LargestX lx = new LargestX();

        int[] result = lx.find(matrix);
        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }

    public void testSeveralCellX() {
        int[][] matrix = new int[][] {
                {1, 0, 0,},
                {0, 1, 1,},
                {0, 0, 0,},
        };

        LargestX lx = new LargestX();

        int[] result = lx.find(matrix);
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }

    public void testOnePerfectCenteredX() {
        int[][] matrix = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        LargestX lx = new LargestX();

        int[] result = lx.find(matrix);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }

    public void testTwoPerfectX() {
        int[][] matrix = new int[][] {
                {1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        LargestX lx = new LargestX();

        int[] result = lx.find(matrix);
        assertEquals(5, result[0]);
        assertEquals(6, result[1]);
    }
}
