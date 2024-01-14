package arraysandhashing;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        smallestDifference(
                new int[] {-1, 3, 5, 10, 20, 28},
                new int[] {15, 17, 26, 134, 135}
        );
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (i < arrayOne.length && j < arrayTwo.length) {
            int fistValue = arrayOne[i];
            int secondValue = arrayTwo[j];
            if (fistValue == secondValue) return new int[]{fistValue, secondValue};

            int currentDiff = 0;
            if ((fistValue > 0 && secondValue > 0) || (fistValue < 0 && secondValue < 0)) {
                currentDiff = Math.abs(fistValue - secondValue);
            } else {
                currentDiff = Math.abs(fistValue) + Math.abs(secondValue);
            }

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result[0] = fistValue;
                result[1] = secondValue;
            }

            if (fistValue < secondValue) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
