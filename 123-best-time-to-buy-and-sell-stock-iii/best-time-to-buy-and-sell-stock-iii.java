class Solution {
    public int maxProfit(int[] prices) {

        int n=prices.length;

        int [][][]dp = new int [n][2][3]; 

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){

                 Arrays.fill(dp[i][j], -1);
            }
           
        }       


        return solve(prices, dp, 0, 1 , 2);
    }

    public int solve(int [] prices, int [][][] dp, int index, int buy, int trans){

        int n=prices.length; 

        if(index==n){
            return 0;
        }


        if(trans==0){
            return 0;
        }

        if(dp[index][buy][trans] != -1){
            return dp[index][buy][trans];
        }

        int profit;


        if(buy==1){
            int take=-prices[index]+ solve(prices, dp, index+1, 0, trans);
            int dntTake=solve(prices, dp, index+1, 1, trans);

            profit=Math.max(take, dntTake);

        }else{

            int sell = prices[index]
                     + solve(prices, dp, index + 1, 1, trans - 1);

            int dntSell=solve(prices, dp , index+1, 0 , trans);    

            profit=Math.max(sell, dntSell);

        }

        return  dp[index][buy][trans]=profit;

    }

}