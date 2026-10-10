class Solution {
    public int lengthOfLIS(int[] nums) {

        int n=nums.length; 
        
        int [][] dp= new int [n][n+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }


        return solve(nums, dp , 0, -1);
    }


    public int solve(int [] nums, int [][] dp, int index, int prev){
        
        int n=nums.length; 

        if(index==n){
            return 0;
        }


        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }

        int take=Integer.MIN_VALUE;

        if( prev==-1 || nums[index]>nums[prev]){
            take=1+solve(nums, dp, index+1, index);
        }

        int dntTake=solve(nums, dp, index+1, prev);


        int maxi=Math.max(take, dntTake);

        return dp[index][prev+1]=maxi;
    }


}