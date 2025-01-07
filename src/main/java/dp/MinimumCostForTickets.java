package dp;

public class MinimumCostForTickets {

    //days = [1,4,6,7,8,20], costs = [2,7,15]
    public static void main(String[] args) {
        mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15});
    }

    private static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        dp[days.length -1] = costs[0];

        for (int i = days.length -2; i >= 0; i --) {
            int cost1 = dp[i+1] + costs[0];
            if (cost1 < 7 && cost1 < 30 ) {
                dp[i] = cost1;
                continue;
            }
            int duration = 7 + days[i];
            int j = i;
            int cost2 = costs[1];
            while (j < days.length && days[j] < duration) {
                j ++;
            }
            if (j < days.length) {
                cost2 += dp[j];
            }

            int duration30 = 30 + days[i];
            j = i;
            int cost3 = costs[2];
            while (j < days.length && days[j] < duration30) {
                j ++;
            }
            if (j < days.length) {
                cost3 += dp[j];
            }

            int minCost = Math.min(cost2, cost3);
            dp[i] = Math.min(cost1, minCost);
        }

        return dp[0];

    }

}
