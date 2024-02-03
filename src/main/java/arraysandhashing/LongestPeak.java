package arraysandhashing;

public class LongestPeak {

    public static void main(String[] args) {
        //1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3
       System.out.println(run(new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3} ));
    }

    private static int run(int[] array) {
        int max = 0;

        for (int i = 1; i < array.length-1; i ++) {
            int previous = i -1;
            int next = i +1;
            if (array[i] > array[previous] && array[i] > array[next]) {
                int current = 3;
                while (previous >= 1 && array[previous] > array[previous -1]) {
                    current ++;
                    previous --;
                }

                while (next < array.length -1 && array[next] > array[next +1]) {
                    current ++;
                    next ++;
                }

                max = Math.max(current, max);
            }
        }

        return max;
    }
}
