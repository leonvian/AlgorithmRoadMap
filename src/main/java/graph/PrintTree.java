package graph;

import tree.TreeNode;

import java.util.List;

/**
 *
 */
public class PrintTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTree(root);
    }

    public static void printTree(TreeNode root) {
        int height = height(root);
        int numRows = height;
        int numCols = (int) (Math.pow(2, height) - 1);
        String[][] matrix = new String[numRows][numCols];
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                matrix[row][col] = "-";
            }
        }

        addNode(matrix, root, -1,0, matrix[0].length-1);

        print(matrix);
    }

    private static void addNode(String[][] matrix, TreeNode node, int row, int colLimitStart, int colLimitEnd) {
        if (node == null) return;

        int nextRow = row + 1;
        int col = (colLimitStart + colLimitEnd) / 2;

        matrix[nextRow][col] = String.valueOf(node.value);

        addNode(matrix, node.left, nextRow, colLimitStart, col);

        addNode(matrix, node.right, nextRow, col +1, colLimitEnd);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;


        return Math.max(height(node.left), height(node.right)) +1;
    }

    private static void print(String[][] matrix) {
        for(String[] array : matrix) {
            System.out.println();
            for (String value : array) {
                System.out.print(value);
            }
        }
        System.out.println();
    }

}
