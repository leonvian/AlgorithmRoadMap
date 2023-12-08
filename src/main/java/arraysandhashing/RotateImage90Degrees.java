package arraysandhashing;

public class RotateImage90Degrees {

    public static void main(String[] args) {
        /*
        {
        {5,1,9,11},
        {2,4,8,10},
        {13,3,6,7},
        {15,14,12,16}
        }
         */
        int[][] matrix = new int[][] {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };

        printMatrix(matrix);
        System.out.println("------");
        rotate2(matrix);
        printMatrix(matrix);

        /*
        printMatrix(matrix);
        System.out.println("------");
        int[][] newMatrix = rotate(matrix);
        printMatrix(newMatrix);
         */
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] lines : matrix) {
            for (int value : lines) {
                System.out.print(" ");
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[][] rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        int newMatrixCol = matrix[0].length - 1;
        int newMatrixLine = 0;
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                newMatrix[newMatrixLine][newMatrixCol] = matrix[row][col];
                newMatrixLine ++;
            }
            newMatrixCol --;
            newMatrixLine = 0;
        }
        return newMatrix;
    }

    public static void rotate2(int[][] matrix) {
        int top = 0;
        int bot = matrix.length -1;
        int left = 0;
        int right = matrix[0].length -1;

        int row = 0;
        int col = 0;
        int tmp = 0;
        int plus = 0;
        int limit = right;
        int startCol = 0;
        while(left < right) {
            tmp = matrix[row][col];

            int old = matrix[top + plus][right];
            matrix[top + plus][right] = tmp;
            tmp = old;

            int old1 = matrix[bot][right - plus];
            matrix[bot][right - plus] = tmp;
            tmp = old1;

            int old2 = matrix[bot-plus][left];
            matrix[bot-plus][left] = tmp;
            tmp = old2;

            matrix[top][left+plus] = tmp;

            col ++;
            plus ++;

            if (col == limit) {
                limit --;
                row ++;
                startCol ++;
                col = startCol;
                left ++;
                right --;
                top ++;
                bot --;
                plus = 0;
            }
        }
    }
}
