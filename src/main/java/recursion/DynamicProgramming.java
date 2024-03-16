package recursion;

public class DynamicProgramming {

    // You may only move down or to the right...

    private final int[][] grid;

    private static final int AVAILABLE = 1;

    public DynamicProgramming(int[][] grid) {
        this.grid = grid;
    }

    public int countPathsWithRecursion(int startRow, int startCol, int endRow, int endCol) {
        if (grid.length == startRow || grid[startRow].length == startCol || grid[startRow][startCol] != AVAILABLE) {
            return 0;
        } else if (startRow == endRow && startCol == endCol) {
            return 1;
        } else {
            return countPathsWithRecursion(startRow + 1, startCol, endRow, endCol) + countPathsWithRecursion(startRow, startCol + 1, endRow, endCol);
        }
    }

    public int countPathsWithDynamicProgramming(int startRow, int startCol, int endRow, int endCol) {
        final int[][] tmpGrid = new int[grid.length][grid[0].length];

        for (int row = endRow; row >= startRow; row--) {
            for (int col = endCol; col >= startCol; col--) {

                if (row == endRow && col == endCol) {
                    continue;
                }

                if (row == grid.length - 1 && grid[row][col] == AVAILABLE) {
                    tmpGrid[row][col] = 1;
                    continue;
                }

                if (col == grid[row].length - 1 && grid[row][col] == AVAILABLE) {
                    tmpGrid[row][col] = 1;
                    continue;
                }

                if (grid[row][col] == AVAILABLE) {
                    tmpGrid[row][col] = tmpGrid[row+1][col] + tmpGrid[row][col+1];
                }

            }
        }

        print(tmpGrid);

        return tmpGrid[startRow][startCol];
    }

    public void print(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                sb.append(",").append(anInt);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
