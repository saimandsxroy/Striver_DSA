class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;

        int [] dp = new int [n];

        Arrays.fill(dp, -1);

        return solve(arr, dp, 0, k);
    }

    private int solve(int [] arr, int [] dp, int index, int k){

        int n=arr.length;

        if(index==n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int maxi=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        int length=0;

        for(int j=index; j<Math.min(n, index+k); j++){

            length++;

            maxi=Math.max(maxi, arr[j]);

            int sum=length*maxi+solve(arr, dp, j+1,k);

            maxAns=Math.max(maxAns, sum);

        }

        return dp[index]= maxAns;
    }
}