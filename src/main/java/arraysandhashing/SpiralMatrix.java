package arraysandhashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
       List<Integer> result = spiralTraverse(new int[][]
        {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        });

       for (int i : result) {
           System.out.print(i);
       }
    }


    static final int RIGHT = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int UP = 3;

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = (array[0].length * array.length);
        int direction = RIGHT;
        int row = 0;
        int col = 0;
        HashSet<String> cache = new HashSet<String>();
        int[] last = new int[2];
        while (result.size() < count) {
            add(array, row, col, direction, cache, result, last);
            direction = nextDirection(direction);
            row = last[0];
            col = last[1];
            if (direction == RIGHT)
                col ++;
            else if (direction == LEFT)
                col --;
            else if (direction == DOWN)
                row ++;
            else
                row --;
        }

        return result;
    }

    private static int[] add(int[][] array,
                             int row,
                             int col,
                             int direction,
                             HashSet<String> cache,
                             ArrayList<Integer> result,
                             int[] last
    ) {
        if (Math.min(row, col) < 0) return last;
        if (row >= array.length || col >= array[0].length) return last;
        String key = ""+ row+col;
        if (cache.contains(key)) return last;

        cache.add(key);

        last[0] = row;
        last[1] = col;

        result.add(array[row][col]);
        if (direction == RIGHT)
            col ++;
        else if (direction == LEFT)
            col --;
        else if (direction == DOWN)
            row ++;
        else
            row --;



        return add(array, row, col, direction, cache, result, last);
    }


    private static int nextDirection(int current) {
        if (current == RIGHT) return DOWN;
        if (current == DOWN) return LEFT;
        if (current == LEFT) return UP;
        if (current == UP) return RIGHT;

        return -1;
    }
}
