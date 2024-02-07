package arraysandhashing;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }

    public static String frequencySort(String s) {
        HashMap<Character, DataCounter> map = new HashMap<Character, DataCounter>();

        for (int i = 0; i < s.length(); i ++) {
            DataCounter dataCounter = null;
            if (map.containsKey(s.charAt(i))) {
                dataCounter = map.get(s.charAt(i));
                dataCounter.count = dataCounter.count + 1;
            } else {
                dataCounter = new DataCounter();
                dataCounter.data = s.charAt(i);
                dataCounter.count = 1;
            }

            map.put(s.charAt(i), dataCounter);
        }

        ArrayList<DataCounter> arrayList = new ArrayList<>(map.values());
        Collections.sort(arrayList);

        StringBuilder sb = new StringBuilder();
        for (int j = arrayList.size() -1; j >= 0; j --) {
            DataCounter current = arrayList.get(j);
            for (int i = 0; i < current.count; i ++) {
                sb.append(current.data);
            }
        }

        return sb.toString();
    }

    private static class DataCounter implements Comparable {
        int count;
        char data;

        public int compareTo(Object other) {
            return Integer.compare(count, ((DataCounter) other).count);
        }

        @Override
        public String toString() {
            return data + " - " + count;
        }
    }

}
