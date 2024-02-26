package arraysandhashing;

import java.util.HashSet;

public class RemoveIsland {

    public static void main(String[] args) {
        int[][] islands = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };
        removeIslands(islands);
    }

    public static int[][] removeIslands(int[][] matrix) {
        HashSet<String> visited = new HashSet<String>();
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                String key = "" + row + "" + col;
                if (matrix[row][col] == 0 || visited.contains(key)) continue;

                boolean[] valid = new boolean[1];
                valid[0] = true;
                markIsland(row, col, matrix, visited, valid);
                if (valid[0]) {
                    transformInWater(row, col, matrix);
                }
            }
        }

        return matrix;
    }

    private static void transformInWater(int row, int col, int[][] matrix) {
        if (matrix[row][col] == 0) return;

        matrix[row][col] = 0;

        transformInWater(row + 1, col, matrix);
        transformInWater(row - 1, col, matrix);
        transformInWater(row, col + 1, matrix);
        transformInWater(row, col - 1, matrix);
    }

    private static void markIsland(int row, int col, int[][] matrix, HashSet<String> visited, boolean[] valid) {
        String key = "" + row + "" + col;
        if (
                Math.min(row, col) == 0 ||
                        row == matrix.length - 1 ||
                        col == matrix[0].length - 1 ||
                        matrix[row][col] == 0 ||
                        visited.contains(key)
        ) {
            if (matrix[row][col] == 1) {
                valid[0] = false;
            }

            return;
        }

        visited.add(key);
        markIsland(row + 1, col, matrix, visited, valid);
        markIsland(row - 1, col, matrix, visited, valid);
        markIsland(row, col + 1, matrix, visited, valid);
        markIsland(row, col - 1, matrix, visited, valid);
    }
}
