package arraysandhashing;

public class MinFallingPath {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(dpSol(matrix));
    }

    public static int dpSol(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }

        for (int row = matrix.length - 2; row >= 0; row--) {
            for (int col = 0; col < matrix[0].length; col++) {
                dp[row][col] = matrix[row][col] + min(dp, row, col);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            min = Math.min(min, dp[0][col]);
        }

        return min;
    }

    private static int min(int[][] dp, int row, int col) {
        int min = dp[row + 1][col];

        if (col - 1 >= 0) {
            min = Math.min(min, dp[row + 1][col - 1]);
        }

        if (col + 1 < dp[0].length) {
            min = Math.min(min, dp[row + 1][col + 1]);
        }

        return min;
    }


    /**
     * Backtracking solution
     */
    public static int minFallingPathSum(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            sum(1, i, matrix, 0);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, sum(0, i, matrix, matrix[0][i]));
        }

        return min;
    }

    private static int sum(int row, int col, int[][] matrix, int currentSum) {
        if (row >= matrix.length)
            return currentSum;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int c = col - 1 + i;
            if (c < 0 || c >= matrix[0].length) continue;

            currentSum += matrix[row][c];
            min = Math.min(min, sum(row + 1, c, matrix, currentSum));
            currentSum -= matrix[row][c];
        }

        return min;
    }
}
