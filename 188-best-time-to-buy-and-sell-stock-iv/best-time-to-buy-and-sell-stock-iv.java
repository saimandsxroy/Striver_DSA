class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n=prices.length;

        int [][][] dp = new int[n][2][k+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }


        return solve(prices,dp, k, 0 , 1, k);

    }

    public int solve(int [] prices,int [][][] dp, int k, int index, int buy, int cap){

        int n=prices.length;

        if(index==n){
            return 0;

        }

        if(cap==0){
            return 0;
        }


        if(dp[index][buy][cap] != -1){
            return dp[index][buy][cap];
        }


        int profit;

        if(buy==1){
            int take=-prices[index]+solve(prices,dp,k , index+1, 0, cap);
            int dntTake=solve(prices,dp, k, index+1, 1, cap);

            profit=Math.max(take, dntTake);
        }else{
            int sell= prices[index] + solve(prices,dp, k, index+1, 1, cap-1);
            int dntSell=solve(prices,dp, k, index+1,0, cap);

            profit=Math.max(sell, dntSell);
        }

        return dp[index][buy][cap]=profit;

    }
}