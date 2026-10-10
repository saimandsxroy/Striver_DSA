class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n+1][n + 1];


        for (int index = n - 1; index >= 0; index--) {
            for (int prev = 0; prev <= index; prev++) {

                int take = Integer.MIN_VALUE;

                if (prev == 0 || nums[index] > nums[prev-1]) {
                    take = 1 + dp[index + 1][index+1];
                }

                int dntTake = dp[index + 1][prev];

                int maxi = Math.max(take, dntTake);

                dp[index][prev] = maxi;
            }
        }


        return dp[0][0];

    }

}