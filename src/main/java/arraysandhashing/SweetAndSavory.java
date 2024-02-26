package arraysandhashing;

import java.util.Arrays;

public class SweetAndSavory {

    public static void main(String[] args) {
       int[] res = sweetAndSavory(new int[] {2, 5, -4, -7, 12, 100, -25}, -7);
       System.out.println(" " + res[0] + " " + res[1]);
    }

    public static int[] sweetAndSavory(int[] dishes, int target) {
        if (dishes.length == 0) return new int[] {0,0};

        Arrays.sort(dishes);

        int left = 0;
        int right = dishes.length -1;

        int diff = Integer.MIN_VALUE;
        int[] res = new int[2];
        while (left < right) {
            if (dishes[left] > 0) return res;
            if (dishes[right] < 0) return res;
            int currentSum =  dishes[left] + dishes[right];
            if (currentSum == target) return new int[] {dishes[left], dishes[right]};

            if(currentSum > target) {
                right --;
            } else {
                if (currentSum > diff) {
                    diff = currentSum;
                    res[0] = dishes[left];
                    res[1] = dishes[right];
                }
                left ++;
            }

        }

        return res;
    }
}
