class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;

        int [][] dp = new int [n][amount+1];

        int inf=1_000_000;


        for(int val=0; val<=amount; val++){
            dp[0][val]= val % coins[0] == 0 ? val/coins[0] : inf;
        }



        for(int i=1; i<n; i++){

            for(int target=0; target<=amount; target++){
                int take=inf;
                if(coins[i]<=target){
                    take=1+dp[i][target-coins[i]];
                }

                int dntTake=dp[i-1][target];

                dp[i][target]=Math.min(take, dntTake);

            }
        }

        return dp[n-1][amount]>=inf ? -1 : dp[n-1][amount];


    }


}