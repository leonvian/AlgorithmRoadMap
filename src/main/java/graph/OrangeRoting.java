package graph;

import java.util.*;

public class OrangeRoting {

    public static void main(String[] args) {
        int[][] case1 = new int[][] {
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };

        //System.out.println(orangesRotting(case1));

        int[][] case2 = new int[][] {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

       // System.out.println(orangesRotting(case2));

        int[][] case3 = new int[][] {
                {1,2}
        };
        System.out.println(orangesRotting(case3));


    }

    public static int orangesRotting(int[][] grid) {
        List<Pos> rottenOranges = new ArrayList();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rottenOranges.add(new Pos(row, col));
                }
            }
        }

        int minute = bfs(rottenOranges, grid);

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return minute;
    }

    private static int bfs(List<Pos> rottenOranges, int[][] grid) {
        Queue<Pos> queue = new LinkedList();
        for (Pos pos : rottenOranges) {
            queue.add(pos);
        }

        int minute = -1;
        HashSet<Pos> inProcess = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pos node = queue.poll();
                grid[node.row][node.col] = 2;

                addIfValid(queue, new Pos(node.row + 1, node.col), grid, inProcess);
                addIfValid(queue, new Pos(node.row - 1, node.col), grid, inProcess);
                addIfValid(queue, new Pos(node.row, node.col + 1), grid, inProcess);
                addIfValid(queue, new Pos(node.row, node.col - 1), grid, inProcess);
            }
            minute++;
        }

        if (minute == -1)
            return 0;

        return minute;
    }

    private static void addIfValid(Queue<Pos> queue, Pos pos, int[][] grid, HashSet<Pos> inProcess) {
        if (Math.min(pos.row, pos.col) < 0) return;
        if (pos.row >= grid.length || pos.col >= grid[0].length) return;
        if (grid[pos.row][pos.col] == 0 || grid[pos.row][pos.col] == 2) return;
        if (inProcess.contains(pos)) return;

        inProcess.add(pos);
        queue.add(pos);
    }

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return row == pos.row && col == pos.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return ""+row+","+ col;
        }
    }
}
