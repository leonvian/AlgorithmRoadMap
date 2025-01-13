package utils;

public class Checker {

    public static void checkEquals(int expected, int value) {
        if (expected == value) {
            System.out.println("PASS! " + expected);
        } else {
            System.out.println("FAIL! Expected -> " + expected + " Value -> " + value);
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value);
            System.out.print(" - ");
        }
    }

}
