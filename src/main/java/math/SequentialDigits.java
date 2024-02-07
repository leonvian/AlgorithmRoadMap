package math;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {
        List<Integer> result = sequentialDigits(58, 155);
        for (int value : result) {
            System.out.println(value);
        }
    }

    private static List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> result = new ArrayList();
        int nextMagnitude = (int)Math.pow(10,String.valueOf(low).length() -1);
        while (nextMagnitude < high) {
            int next = nextSequence(nextMagnitude, true);
            while (next <= high) {
                if (next >= low)  {
                    result.add(next);
                }
                next = nextSequence(next, false);
            }
            nextMagnitude = nextMagnitude * 10;
        }

        return result;
    }

    private static int nextSequence(int value, boolean first) {
        char[] array = String.valueOf(value).toCharArray();
        int previous = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i ++) {
            if (first && i == 0) {
                previous = Character.getNumericValue(array[i]);
                sb.append(previous);
                first = false;
                continue;
            }

            if (i == 0) {
                previous = Character.getNumericValue(array[i]) +1;
            } else {
                previous = previous + 1;
                if(previous > 9) return Integer.MAX_VALUE;
            }
            sb.append(previous);
        }

        return Integer.valueOf(sb.toString());
    }
}
