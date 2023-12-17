package arraysandhashing;

/**
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 */
public class SpecialBinaryMatrix {

    public static void main(String[] args) {
        numSpecial(
                new int[][] {
                        { 0,1,0 },
                        { 0,0,0 },
                        { 1,0,0 },
                        { 1,0,0 }
                }
        );
    }

    public static int numSpecial(int[][] mat) {
        int count = 0;
        for (int row = 0; row < mat.length; row ++) {
            for (int col = 0; col < mat[0].length; col ++) {
                if (mat[row][col] == 1 && isZeroeRow(row, col, mat) && isZeroeCol(row, col, mat)) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static boolean isZeroeRow(int row, int col, int[][] mat) {
        int left = col - 1;
        while (left >= 0) {
            if (mat[row][left] == 1) return false;

            left --;
        }

        int right = col + 1;
        while (right < mat[0].length) {
            if (mat[row][right] == 1) return false;

            right ++;
        }

        return true;
    }

    public static boolean isZeroeCol(int row, int col, int[][] mat) {
        int up = row - 1;
        while (up >= 0) {
            if (mat[up][col] == 1) return false;

            up --;
        }

        int down = row + 1;
        while (down < mat.length) {
            if (mat[down][col] == 1) return false;

            down ++;
        }

        return true;
    }
}
