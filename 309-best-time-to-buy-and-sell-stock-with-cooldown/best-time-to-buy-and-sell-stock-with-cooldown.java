class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;

                if (buy == 1) {
                    int take = -prices[index] + dp[index + 1][0];
                    int dntTake = dp[index + 1][1];

                    profit = Math.max(take, dntTake);

                } else {
                    int sell = prices[index] + dp[index + 2][1];
                    int dntSell = dp[index + 1][0];

                    profit = Math.max(sell, dntSell);

                }

                dp[index][buy] = profit;

            }
        }

        return dp[0][1];

    }

}