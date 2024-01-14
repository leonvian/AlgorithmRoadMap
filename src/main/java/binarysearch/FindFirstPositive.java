package binarysearch;

public class FindFirstPositive {

    public static void main(String[] args) {
       System.out.println(findFirstPositive(new int[] {-3, -2, -1, 0 , 1 , 2, 3}));
       System.out.println(findFirstPositive(new int[] {1, 2, 3, 5, 6, 8, 9}));
       System.out.println(findFirstPositive(new int[] {-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20}));
       System.out.println(findFirstPositive(new int[] {-10, -5, 0, 5, 10}));
    }

    private static int findFirstPositive(int[] array) {
        if (array[array.length - 1]  > 0) return -1;
        if (array[0] > 0) return 0;

        int left = 0;
        int right = array.length;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0 || (array[mid] >= 0 && array[mid -1] < 0)) {
                return mid;
            }

            if (array[mid] > 0) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return -1;
    }
}
