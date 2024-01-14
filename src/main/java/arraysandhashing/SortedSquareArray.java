package arraysandhashing;

public class SortedSquareArray {

    public static void main(String[] args) {
        sortedSquaredArray(new int[] { -1, 0, 1, 2, 3});
    }

    public static int[] sortedSquaredArray(int[] array) {
        if (array[0] >= 0) {
            for (int i = 0; i < array.length; i ++) {
                array[i] = array[i] * array[i];
            }
            return array;
        }

        if (array[array.length -1] < 0) {
            int pos = 0;
            int[] newArray = new int[array.length];
            for (int i = array.length -1; i >= 0; i --) {
                newArray[pos] = array[i] * array[i];
                pos ++;
            }
            return newArray;
        }

        int right = findFirstPositive(array);

        int left = right -1;
        int[] newArray = new int[array.length];
        int pos = 0;
        while (left >= 0 && right < array.length) {
            if (square(array[right]) < square(array[left])) {
                newArray[pos] = square(array[right]);
                right ++;
            } else {
                newArray[pos] = square(array[left]);
                left --;
            }
            pos ++;
        }

        while (left >= 0) {
            newArray[pos] = square(array[left]);
            left --;
            pos ++;
        }

        while (right < array.length) {
            newArray[pos] = square(array[right]);
            right ++;
            pos ++;
        }


        return newArray;
    }

    private static int square(int value) {
        return value * value;
    }

    private static int findFirstPositive(int[] array) {
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
