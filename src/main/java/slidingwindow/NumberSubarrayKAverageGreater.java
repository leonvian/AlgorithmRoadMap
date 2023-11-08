package slidingwindow;

public class NumberSubarrayKAverageGreater {

    //target = 2,2,2,2,5,5,5,8, k = 3, threshold = 4
    public static void main(String[] args) {
    /*    System.out.println(numOfSubarrays(
                new int[] {2,2,2,2,5,5,5,8}, 3, 4
        )); */

        System.out.println(numOfSubarrays(
                new int[] {11,13,17,23,29,31,7,5,2,3}, 3, 5
        ));
    }

    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;

        for (int i = 0; i < k; i ++) {
            sum += arr[i];
        }

        int currentAverage = sum / k;
        if (currentAverage >= threshold) {
            result ++;
        }

        int left = 0;
        for (int right = k; right < arr.length; right ++) {
            sum = sum - arr[left];
            sum = sum + arr[right];

             currentAverage = sum / k;
            if (currentAverage >= threshold) {
                result ++;
            }
            left ++;
        }

        return result;
    }

}
