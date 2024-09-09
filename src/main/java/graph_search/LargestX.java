package graph_search;

public class LargestX {


    public int[] find(int[][] matrix) {
        int maxSize = 0;
        int[] result = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int tmpMaxSize = calculateSize(matrix, row, col, 0);
                if (tmpMaxSize > maxSize) {
                    maxSize = tmpMaxSize;
                    result[0] = row;
                    result[1] = col;
                }
            }
        }

        return result;
    }

    private int calculateSize(int[][] matrix, int row, int col, int size) {
        if (row - size < 0
                || row + size > matrix.length - 1
                || col - size < 0
                || col + size > matrix[row].length - 1
                || matrix[row][col] == 0) {
            return size;
        }

        if (matrix[row - size][col - size] == 1
                && matrix[row - size][col + size] == 1
                && matrix[row + size][col - size] == 1
                && matrix[row + size][col + size] == 1) {
            size++;
            return calculateSize(matrix, row, col, size);
        }

        return size;
    }
}
