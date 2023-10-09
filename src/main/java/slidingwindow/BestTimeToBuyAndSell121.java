package slidingwindow;

public class BestTimeToBuyAndSell121 {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }

            right ++;
        }
        return maxProfit;
    }

    public static int firstSolution(int[] prices) {
        Integer min = null;
        int max = 0;
        int maxResult = 0;
        for (int i = prices.length -1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
                min = null;
            } else if (min == null || prices[i] < min) {
                min = prices[i];
            }

            if (min == null) {
                continue;
            }

            int result = max - min;
            if (result > maxResult) {
                maxResult = result;
            }
        }

        return maxResult;
    }
}
