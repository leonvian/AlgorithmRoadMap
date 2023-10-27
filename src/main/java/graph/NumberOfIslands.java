package graph;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid =
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}

                };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int row = 0; row < grid.length; row ++){
            for(int col = 0; col < grid[0].length; col ++){
                if (grid[row][col] == '1') {
                    numIslands ++;
                    markIsland(grid, row, col);
                }
            }
        }

        return numIslands;
    }

    private static void markIsland(char[][] grid, int row, int col) {
        if (Math.min(row, col) < 0 ||  row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }

        if (grid[row][col] == '1') {
            grid[row][col] = '2';
        }

        markIsland(grid, row +1, col);
        markIsland(grid, row -1, col);
        markIsland(grid, row, col -1);
        markIsland(grid, row, col +1);
    }

}
