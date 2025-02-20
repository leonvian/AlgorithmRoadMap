package precomputation;

public class ShiftingLetters2 {

    public static void main(String[] args) {
       //String res = shiftingLetters("abc", new int[][] {
       //         {0,1,0},{1,2,1},{0,2,1}
//        });

        System.out.println(shiftingLetters("xuwdbdqik",
         new int[][]{
                 {4,8,0},{4,4,0},{2,4,0},{2,4,0},{6,7,1},{2,2,1},{0,2,1},{8,8,0},{1,3,1}
        }));
    }

    public static String sol2(String s, int[][] shifts) {
        int[] moves = new int[s.length() + 1]; // Use an extra space for range manipulation

        // Apply the range shifts using prefix sum approach
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            moves[start] += (direction == 1) ? 1 : -1;
            moves[end + 1] += (direction == 1) ? -1 : 1;
        }

        // Compute cumulative shifts
        int[] cumulativeShifts = new int[s.length()];
        int shiftSum = 0;
        for (int i = 0; i < s.length(); i++) {
            shiftSum += moves[i];
            cumulativeShifts[i] = shiftSum;
        }

        // Apply the shifts to the string
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int shift = cumulativeShifts[i] % 26;
            if (shift < 0) shift += 26; // Handle negative shifts
            array[i] = (char) ((array[i] - 'a' + shift) % 26 + 'a');
        }

        return new String(array);
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int[] moves = new int[s.length()];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            while (start <= end) {
                if (direction == 1) {
                    moves[start] = moves[start] +1;
                } else {
                    moves[start] = moves[start] -1;
                }
                start ++;
            }
        }

        char[] array = s.toCharArray();
        for (int i = 0; i < moves.length; i ++) {
            if (moves[i] == 0) continue;

            shift(array, i, moves[i]);
        }

        return new String(array);
    }

    private static void shift(char[] array, int pos, int move) {
        if (move > 0) {
            move = move % 26;
            int newChar = (array[pos] - 'a') + move;
            if (newChar >= 26) {
                newChar = newChar - 26;
            }

            array[pos] = (char)(newChar + 'a');
        } else {
            move = Math.abs(move) % 26;
            int newChar = (array[pos] - 'a') - move;
            if (newChar < 0) {
                newChar = 26 - Math.abs(newChar);
            }
            array[pos] = (char)(newChar + 'a');
        }
    }
}
