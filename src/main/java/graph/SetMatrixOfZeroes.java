package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n integer matrix , if an element is 0, set its entire row and column to 0's.
 */
public class SetMatrixOfZeroes {

    public void setZeroes(int[][] matrix) {
        List<int[]> data = new ArrayList();
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                if (matrix[row][col] == 0) {
                    int[] target = new int[] {row, col};
                    data.add(target);
                }
            }
        }

        for (int[] target : data) {
            markRowAndColAsZero(matrix, target[0], target[1]);
        }
    }

    private void markRowAndColAsZero(
            int[][] matrix,
            int row,
            int col) {

        markRightMatrix(matrix, row, col);
        markLeftMatrix(matrix, row, col);
        markUpMatrix(matrix, row, col);
        markDownMatrix(matrix, row, col);
    }

    private void markRightMatrix(int[][] matrix,
                                 int row,
                                 int col) {
        if (isOutOfBounds(matrix, row, col)) return;

        matrix[row][col] = 0;
        markRightMatrix(matrix, row, col +1);
    }

    private void markLeftMatrix(int[][] matrix,
                                int row,
                                int col) {
        if (isOutOfBounds(matrix, row, col)) return;

        matrix[row][col] = 0;
        markLeftMatrix(matrix, row, col -1);
    }

    private void markUpMatrix(int[][] matrix,
                              int row,
                              int col) {
        if (isOutOfBounds(matrix, row, col)) return;

        matrix[row][col] = 0;
        markUpMatrix(matrix, row-1, col);
    }

    private void markDownMatrix(int[][] matrix,
                                int row,
                                int col) {
        if (isOutOfBounds(matrix, row, col)) return;

        matrix[row][col] = 0;
        markDownMatrix(matrix, row+1, col);
    }

    private boolean isOutOfBounds(
            int[][] matrix,
            int row,
            int col) {
        if (Math.min(row, col) < 0) return true;
        if (row >= matrix.length) return true;
        if (col >= matrix[0].length) return true;


        return false;
    }
}
