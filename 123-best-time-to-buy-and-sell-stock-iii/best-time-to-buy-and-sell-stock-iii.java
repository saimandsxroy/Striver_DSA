class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;


        int[][] prev = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {

            int [][] curr= new int[2][3];

            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <=2; cap++) {
                    int profit;

                    if (buy == 1) {
                        int take = -prices[index] + prev[0][cap];
                        int dntTake = prev[1][cap];

                        curr[buy][cap] = Math.max(take, dntTake);

                    } else {

                        int sell = prices[index]
                                + prev[1][cap - 1];

                        int dntSell = prev[0][cap];

                        curr[buy][cap] = Math.max(sell, dntSell);

                    }
                }
            }
            prev=curr;
        }

        return prev[1][2];

    }

}