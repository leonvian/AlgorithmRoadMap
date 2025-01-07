package greedy;

public class MinOperationsToMakeColumnsIncreasing {

    public static final void main(String[] args) {
        System.out.println(answerString("nbjnc", 2));
    }

    /*
    Q2. Find the Lexicographically Largest String From the Box I
Attempted
Medium
4 pt.
You are given a string word, and an integer numFriends.

Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:

word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
All the split words are put into a box.
Find the lexicographically largest string from the box after all the rounds are finished.

A string a is lexicographically smaller than a string b if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
If the first min(a.length, b.length) characters do not differ, then the shorter string is the lexicographically smaller one
     */
    public static String answerString(String word, int numFriends) {
        int maxSize = word.length() - (numFriends - 1);

        int largestChar = Integer.MIN_VALUE;
        int largestPos = 0;
        for (int i = 0; i < word.length(); i ++) {
            int charSize = word.charAt(i) - 'a';
            if (charSize > largestChar) {
                largestChar = charSize;
                largestPos = i;
            }
        }

        String res = word.substring(largestPos, Math.min(largestPos + maxSize, word.length() - 1));
        return res;

    }

    public static int minimumOperations(int[][] grid) {
        if (grid.length <= 1) return 0;

        int count = 0;
        for (int col = 0; col < grid[0].length; col ++) {
            int previous = grid[0][col];
            for (int row = 1; row < grid.length; row ++) {
                if (previous < grid[row][col]) {
                    previous = grid[row][col];
                    continue;
                }
                int diff = previous - grid[row][col] + 1;
                previous = grid[row][col] + diff;
                count += diff;
            }
        }

        return count;
    }
}
