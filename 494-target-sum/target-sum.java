class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Target is outside the possible range
        if (target > totalSum || target < -totalSum) {
            return 0;
        }

        int offset = totalSum;

        int[][] dp = new int[n][2 * totalSum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, dp, n - 1, target, offset);
    }

    public int solve(int[] nums, int[][] dp, int index, int target, int offset) {

    // Impossible target
    if (target < -offset || target > offset) {
        return 0;
    }

    if (index == 0) {

        if (target == 0 && nums[0] == 0) {
            return 2;
        }

        if (target == nums[0] || target == -nums[0]) {
            return 1;
        }

        return 0;
    }

    int col = target + offset;

    if (dp[index][col] != -1) {
        return dp[index][col];
    }

    int plus = solve(
        nums,
        dp,
        index - 1,
        target - nums[index],
        offset
    );

    int minus = solve(
        nums,
        dp,
        index - 1,
        target + nums[index],
        offset
    );

    return dp[index][col] = plus + minus;
}
}