package graph_search;

public class CountPaths {
    private final int[][] grid;

    public CountPaths(int[][] grid) {
        this.grid = grid;
    }

    public int run() {
        return countPaths(0, 0);
    }

    private int countPaths(int startRow, int startCol) {
        if (isNotValid(startRow, startCol)) {
            return 0;
        } else if (isAtEnd(startRow, startCol)) {
            return 1;
        } else {
            return countPaths(startRow + 1, startCol) + countPaths(startRow, startCol + 1);
        }
    }

    public int runWithMemoization() {
        Integer[][] memo = new Integer[grid.length][grid[grid.length-1].length];
        return countPaths(0, 0, memo);
    }

    private int countPaths(int startRow, int startCol, Integer[][] memo) {
        if (isNotValid(startRow, startCol)) {
            return 0;
        } else if (isAtEnd(startRow, startCol)) {
            return 1;
        } else if (memo[startRow][startCol] == null) {
            memo[startRow][startCol] =
                    countPaths(startRow + 1, startCol, memo) + countPaths(startRow, startCol + 1, memo);
        }

        return memo[startRow][startCol];
    }

    private boolean isNotValid(int row, int col) {
        return grid[row][col] == 0;
    }

    private boolean isAtEnd(int row, int col) {
        return row >= grid.length - 1 || col >= grid[grid.length - 1].length - 1;
    }

}
