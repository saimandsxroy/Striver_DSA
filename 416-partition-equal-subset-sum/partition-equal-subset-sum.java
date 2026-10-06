class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int ttlSum = 0;

        for (int i = 0; i < nums.length; i++) {
            ttlSum += nums[i];
        }

        if (ttlSum % 2 != 0) {
            return false;
        }

        int target = ttlSum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for (int index = 0; index < n; index++) {
            dp[index][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int targ = 1; targ <= target; targ++) {

                boolean take = false;

                if (nums[index] <= targ) {
                    take = dp[index-1][targ-nums[index]];
                }

                boolean dntTake = dp[index-1][targ];

                dp[index][targ]= take || dntTake;
            }
        }

        return dp[n-1][target];

    }

    
}