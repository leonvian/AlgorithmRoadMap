package backtracking;

import tree.TreeNode;

/**
 * Put more items on the bag that until the capacity that will have more profit.
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] profit = new int[] { 4, 4, 7, 1 };
        int[] weight = new int[] { 5, 2, 3, 1 };
        int capacity = 8;

        int result = addItem(profit, weight, capacity, 0, 0, 0);
        System.out.println(result);
    }

    private static int addItem(int[] profit, int[] weight, int capacity, int currentPos, int maxProfit, int maxWeight) {
        if (maxWeight == capacity || currentPos > weight.length -1) {
            return maxProfit;
        }


        if (maxWeight > capacity) {
            return -1;
        }

        System.out.println("Trying " + currentPos + " " + maxWeight);

        maxWeight += weight[currentPos];
        maxProfit += profit[currentPos];

        int tryOne = addItem(profit, weight, capacity, currentPos +1, maxProfit, maxWeight);

        maxWeight -= weight[currentPos];
        maxProfit -= profit[currentPos];

        int tryTwo = addItem(profit, weight, capacity, currentPos + 1, maxProfit, maxWeight);

        return Math.max(tryOne, tryTwo);
    }


    class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object pos) {
            if (pos instanceof Pos) {
                Pos pos1 = (Pos) pos;
                return this.row == pos1.row && this.col == pos1.col;
            } else {
                return false;
            }
        }

        public int hashCode()  {
            return row + col * 7;
        }
    }

}
