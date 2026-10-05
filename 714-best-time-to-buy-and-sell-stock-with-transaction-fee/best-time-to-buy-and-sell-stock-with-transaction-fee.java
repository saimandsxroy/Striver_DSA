class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        int [][] dp= new int[n][2];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }


        return solve(prices, dp, 0, 1, fee);

    }

    public int solve(int [] prices, int [][] dp, int index,  int buy, int fee){

        int n=prices.length;

        if(index==n){
            return 0;
        }


        int profit; 


        if(dp[index][buy] != -1){
            return dp[index][buy];
        }


        if(buy==1){
            int take=-prices[index]+solve(prices, dp, index+1, 0, fee);
            int dntTake=solve(prices, dp, index+1, 1, fee);

            profit=Math.max(take, dntTake);


        }else{
            int sell=prices[index]-fee+solve(prices, dp, index+1, 1, fee);
            int dntSell=solve(prices, dp, index+1, 0, fee);

            profit=Math.max(sell, dntSell);

        }

        return dp[index][buy]=profit;


    }


}