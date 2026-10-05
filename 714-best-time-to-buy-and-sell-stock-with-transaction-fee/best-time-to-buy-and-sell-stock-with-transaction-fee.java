class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[] prev = new int[2];

        int profit;

        for (int index = n - 1; index >= 0; index--) {
            int [] curr= new int[2];

            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int take = -prices[index] + prev[0];
                    int dntTake = prev[1];

                    profit = Math.max(take, dntTake);

                } else {
                    int sell = prices[index] - fee + prev[1];
                    int dntSell = prev[0];

                    profit = Math.max(sell, dntSell);

                }

                curr[buy] = profit;
            }
            prev=curr;
        }


        return prev[1];

    }

}