package arraysandhashing;

import java.util.HashSet;

public class IslandCount {

    public static void main(String[] args) {
        
    }

    static int getNumberOfIslands(int[][] matrix) {
        int count = 0;
        HashSet<String> visited = new HashSet<String>();
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                String key = ""+ row + ""+ col;
                if (matrix[row][col] == 0 || visited.contains(key)) continue;

                count ++;
                markIsland(row, col, matrix, visited);
            }
        }

        return count;
    }

    private static void markIsland(int row, int col, int[][] matrix, HashSet<String> visited) {
        String key = ""+ row + ""+ col;
        if (
                Math.min(row, col) < 0 ||
                        row >= matrix.length ||
                        col >= matrix[0].length ||
                        matrix[row][col] == 0 ||
                        visited.contains(key)
        ) return;

        visited.add(key);

        markIsland(row + 1, col, matrix, visited);
        markIsland(row - 1, col, matrix, visited);
        markIsland(row, col + 1, matrix, visited);
        markIsland(row, col - 1, matrix, visited);
    }

}
