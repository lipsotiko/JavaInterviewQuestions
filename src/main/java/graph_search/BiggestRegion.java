package graph_search;

public class BiggestRegion {

    int[][] grid;

    public BiggestRegion(int[][] grid) {
        this.grid = grid;
    }

    public int find() {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                int size = countAdjacent(grid, row, col);
                if (size > max) {
                    max = size;
                }
            }
        }

        return max;
    }

    private int countAdjacent(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[row].length - 1) {
            return 0;
        }

        if (grid[row][col] == 1) {

            grid[row][col] = 0;

            int size = 1;
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    size += countAdjacent(grid, r, c);
                }
            }
            return size;
        }
        return 0;
    }
}
