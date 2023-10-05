package arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 The solution is to examine every row and verify that there are no duplications in:

 Each row
 Each column
 Each 3x3 square
 To determine the appropriate square (quadrant) to check:

 Divide the row number by 3
 Divide the column number by 3
 For example, consider the position at row 4 and column 4.
 If we divide 4 by 3 and 4 by 3, we get the quadrant [1,1]. In this case, quadrant 1,1 should not contain duplicate numbers.
 */
public class ValidSudoku36 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        sol.isValidSudoku(board);
    }

    public static class Solution {
        public boolean isValidSudoku(char[][] board) {

            System.out.println(checkCol(board));
            System.out.println(checkRow(board));
            System.out.println(checkSquad(board));


            return checkCol(board) && checkRow(board) && checkSquad(board);
        }

        private boolean checkSquad(char[][] board) {
            HashMap<Pair, HashSet<Character>> data = new HashMap<>();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    int squadRow = row / 3;
                    int squadCol = col / 3;
                    Pair pair = new Pair(squadCol, squadRow);
                    char currentVal = board[row][col];
                    if (currentVal == '.')
                        continue;

                    if (data.containsKey(pair)) {
                        if (data.get(pair).contains(currentVal)) {
                            return false;
                        } else {
                            data.get(pair).add(currentVal);
                        }
                    } else {
                        HashSet<Character> hashSet = new HashSet<>();
                        hashSet.add(currentVal);
                        data.put(pair, hashSet);
                    }
                }
            }

            return true;
        }

        private boolean checkRow(char[][] board) {
            for (int line = 0; line < board.length; line++) {
                HashSet<Character> data = new HashSet();
                for (int col = 0; col < board[0].length; col++) {
                    char current = board[line][col];
                    if (current != '.') {
                        if (data.contains(current)) {
                            return false;
                        } else {
                            data.add(current);
                        }
                    }
                }
            }

            return true;
        }

        private boolean checkCol(char[][] board) {
            for (int col = 0; col < board[0].length; col++) {
                HashSet<Character> data = new HashSet();
                for (int line = 0; line < board.length; line++) {
                    char current = board[line][col];
                    if (current != '.') {
                        if (data.contains(current)) {
                            return false;
                        } else {
                            data.add(current);
                        }
                    }
                }
            }
            return true;
        }

        private static class Pair {
            int col;
            int row;

            public Pair(int col, int row) {
                this.col = col;
                this.row = row;
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


}
