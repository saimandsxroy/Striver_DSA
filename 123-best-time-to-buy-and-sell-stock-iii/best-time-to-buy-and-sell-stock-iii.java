class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int index = 0; index <= n; index++) {
            dp[index][0][0] = 0;
            dp[index][1][0] = 0;
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <=2; cap++) {
                    int profit;

                    if (buy == 1) {
                        int take = -prices[index] + dp[index + 1][0][cap];
                        int dntTake = dp[index + 1][1][cap];

                        dp[index][buy][cap] = Math.max(take, dntTake);

                    } else {

                        int sell = prices[index]
                                + dp[index + 1][1][cap - 1];

                        int dntSell = dp[index + 1][0][cap];

                        dp[index][buy][cap] = Math.max(sell, dntSell);

                    }
                }
            }
        }

        return dp[0][1][2];

    }

}