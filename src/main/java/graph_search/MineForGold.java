package graph_search;

public class MineForGold {


    public int findGreatestPathForDiggingGold(int[][] mine) {
        if (mine == null) return 0;
        int max = 0;
        for(int row = 0; row < mine.length; row++) {
            for(int col = 0; col < mine[row].length; col++) {
                if (mine[row][col] > 0) {
                    int tmpMax = findGold(mine, row, col, new boolean[mine.length][mine[0].length]);
                    if (tmpMax > max) {
                        max = tmpMax;
                    }
                }
            }
        }
        return max;
    }

    private int findGold(int[][] mine, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= mine.length || col >= mine[row].length || mine[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int top = findGold(mine, row-1, col, visited);
        int bottom = findGold(mine, row+1, col, visited);
        int left = findGold(mine, row, col-1, visited);
        int right = findGold(mine, row, col+1, visited);

        visited[row][col] = false;

        int max = Math.max(top, bottom);
        max = Math.max(max, left);
        max = Math.max(max, right);

        return max + mine[row][col];
    }
}
