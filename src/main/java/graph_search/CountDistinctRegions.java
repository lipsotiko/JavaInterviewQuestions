package graph_search;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctRegions {

    /**
     *  Also known as "count distinct islands"
     *  A regions distinction is characterized by having the same shape as another
     *      region without requiring rotation or reflection.
     */

    int[][] grid;

    public CountDistinctRegions(int[][] grid) {
        this.grid = grid;
    }

    public int count() {
        if (grid == null) {
            return 0;
        }
        Set<String> distinctIslands = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    String shape = findPath(grid, row, col, "X");
                    distinctIslands.add(shape);
                }
            }
        }

        return distinctIslands.size();
    }

    private String findPath(int[][] grid, int row, int col, String shape) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[row].length - 1 || grid[row][col] == 0) {
            return "O";
        }

        grid[row][col] = 0;

        String left = findPath(grid, row, col - 1, "L");
        String right = findPath(grid, row, col + 1, "R");
        String top = findPath(grid, row - 1, col, "T");
        String bottom = findPath(grid, row + 1, col, "B");

        return shape + left + right + top + bottom;
    }
}
