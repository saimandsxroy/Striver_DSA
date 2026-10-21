class Solution {
    public int minCost(int n, int[] cuts) {

        int c=cuts.length;
        
        int [][] dp= new int[c+1][c+1];


        int [] arr= new int[c+2];

        arr[0]=0;
        arr[c+1]=n;


        for(int i=0; i<c; i++){
            arr[i+1]=cuts[i];
        }

        Arrays.sort(arr);

        for(int i=0; i<=c; i++){
            Arrays.fill(dp[i],-1);
        }


        return solve(dp, arr, 1,c);

    }

    private int solve(int [][] dp, int [] arr, int start, int end){

        if(start>end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }


        int mini=Integer.MAX_VALUE;


        for(int k=start; k<=end; k++){
             int cost=arr[end+1]-arr[start-1] + solve(dp, arr, start, k-1)+ solve(dp, arr, k+1, end);

             mini=Math.min(mini, cost);
        }


        return dp[start][end]=mini;
       

    }
}