package graph;

import java.util.*;

public class ShortestPathMatrix {

    public static void main(String[] args) {
        int[][] grid =
                {
                        {0,0,0,0,0},
                        {1,1,1,0,0},
                        {1,1,0,0,0},
                        {0,0,0,0,0}
                };

        System.out.println(bfs(grid));
    }

    private static int bfs(int[][] grid) {
        if (grid.length == 0) return -1;
        if (grid[0][0] == 1) return -1;

        int rowsSize = grid.length;
        int colSize = grid[0].length;
        Pair first = new Pair(0, 0);
        LinkedList<Pair> queue = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();
        queue.add(first);
        int lenght = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            lenght ++;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                if (current.row == rowsSize -1 && current.col == colSize -1) {
                    return lenght;
                }

                Pair[] neighbors = new Pair[] {
                        new Pair(current.row +1, current.col+1),
                        new Pair(current.row +1, current.col),
                        new Pair(current.row -1, current.col),
                        new Pair(current.row, current.col +1),
                        new Pair(current.row, current.col -1),
                        new Pair(current.row -1, current.col-1),
                        new Pair(current.row +1, current.col-1),
                        new Pair(current.row -1, current.col+1),
                };

                for (Pair direction : neighbors) {
                    if (isValid(direction, grid, visited)) {
                        queue.add(direction);
                        visited.add(direction);
                    }
                }

            }
        }

        return -1;
    }

    private static boolean isValid(Pair pair, int[][] grid, HashSet<Pair> visited) {
        int rowsSize = grid.length;
        int colSize = grid[0].length;

        int row = pair.row;
        int col = pair.col;
        if (
                Math.min(row, col) < 0 ||
                        row >= rowsSize ||
                        col >= colSize ||
                        visited.contains(pair) ||
                        grid[row][col] == 1
        ) {
            return false;
        } else {
            return true;
        }
    }

    private static class Pair {

        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return col == pair.col && row == pair.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }
    }



}
