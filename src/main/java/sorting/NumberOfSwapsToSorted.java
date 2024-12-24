package sorting;

import java.util.HashMap;

public class NumberOfSwapsToSorted {

    // Given a sorted and an unsorted array, count the number of swaps for the unsorted array become sorted.


    public static void main(String[] args) {
        int[] sorted = new int[] {
                1, 2, 3, 4, 5, 6
        };

        int[] array = new int[] {
                6, 4, 3, 1, 5, 2
        };

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i ++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i ++) {
            if (array[i] != sorted[i]) {
                int currentVal = array[i];
                int targetVal = sorted[i];

                int targetValPosition = map.get(targetVal);
                int targetPosition = i;

                map.put(sorted[i], targetPosition);
                map.put(currentVal, targetValPosition);

                swap(array, targetValPosition, targetPosition);
            }
        }

        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }

    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
