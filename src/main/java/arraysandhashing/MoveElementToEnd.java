package arraysandhashing;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        moveElementToEnd(toList(new int[] { 3, 3, 3, 3, 3 } ), 3);
    }

    private static List<Integer> toList(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int current : array) {
            arrayList.add(current);
        }
        return arrayList;
    }

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {

        int last = array.size() -1;
        int end = last;
        while (end >= 0 && array.get(end) == toMove) {
            end --;
        }

        if (end < 0) {
            return array;
        }

        int posToReplace = end;
        for (int i = posToReplace-1; i >= 0; i --) {
            if (array.get(i) == toMove) {
                int tmp = array.get(posToReplace);
                array.set(posToReplace, toMove);
                array.set(i, tmp);
                posToReplace --;

                if (posToReplace <= 0) return array;
            }
        }

        return array;
    }

}
