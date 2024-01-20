package design;

public class RandomizedSetMain {

    /*
     [
        [],
        add [0],
        add [1],
        del [0],
        add [2],
        del [1],
        ran []]
     */
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);

        System.out.println(randomizedSet.getRandom());
    }
}
