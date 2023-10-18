package binarysearch;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int targetLine = findLine(matrix, target);
        if (targetLine == -1) return false;
        return search(matrix[targetLine], target) != -1;
    }

    private int search(int[] array, int target) {
        int l = 0;
        int r =  array.length -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }

    private int findLine(int[][] matrix, int target) {
        int l = 0;
        int h = matrix.length -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            int start = matrix[mid][0];
            int end = matrix[mid][matrix[mid].length -1];

            if (target >= start && target <= end) {
                return mid;
            } else if (target < start) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

}
