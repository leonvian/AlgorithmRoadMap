package arraysandhashing;

public class QuickSortImpl {

    public static void main(String[] args) {
        int[] target = new int[] { 5, 10, 2, 1, 0, 3, 9, 8};
        quickSort(target, 0, target.length -1);

        for (int value : target) {
            System.out.print(value);
            System.out.print("-");
        }

    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements before partition and after partition
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        // Swap pivot
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
