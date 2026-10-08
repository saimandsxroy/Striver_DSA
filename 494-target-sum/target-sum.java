class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Target is outside possible range
        if (Math.abs(target) > sum) {
            return 0;
        }

        // sum - target must be even
        if ((sum - target) % 2 != 0) {
            return 0;
        }

        int targ = (sum - target) / 2;

        int[][] dp = new int[n][targ + 1];

        // Base case
        dp[0][0] = 1;

        if (nums[0] <= targ) {
            dp[0][nums[0]]++;
        }

        for (int i = 1; i < n; i++) {

            for (int newTarg = 0; newTarg <= targ; newTarg++) {

                int take = 0;

                if (nums[i] <= newTarg) {
                    take = dp[i - 1][newTarg - nums[i]];
                }

                int dntTake = dp[i - 1][newTarg];

                dp[i][newTarg] = take + dntTake;
            }
        }

        return dp[n - 1][targ];
    }
}