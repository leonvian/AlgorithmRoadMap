package design;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {

    HashMap<Integer, Integer> map = new HashMap();
    ArrayList<Integer> array = new ArrayList<Integer>();
    int index = 0;


    public RandomizedSet() {

    }
    public boolean insert(int val) {
        boolean exist = map.containsKey(val);
        if (exist) return false;

        map.put(val, index);
        array.add(index, val);
        index ++;

        return true;
    }

    public boolean remove(int val) {
        boolean exist = map.containsKey(val);
        if (!exist) return false;

        int lastElement = array.get(index -1);
        int currentIndex = map.get(val);
        array.remove(currentIndex);
        array.add(currentIndex, lastElement);
        map.remove(val);
        map.put(lastElement, currentIndex);
        index --;

        return true;
    }

    public int getRandom() {
        int randomIndex = getRandomNumber(0, index -1);
        return array.get(randomIndex);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
