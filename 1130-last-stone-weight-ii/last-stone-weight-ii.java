class Solution {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += stones[i];
        }

        boolean[][] dp = new boolean[n][totalSum + 1];

        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = true;
        }

        if (stones[0] <= totalSum) {
            dp[0][stones[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int targ = 1; targ <= totalSum; targ++) {

                boolean take = false;

                if (stones[index] <= targ) {
                    take = dp[index - 1][targ - stones[index]];
                }

                boolean dntTake = dp[index - 1][targ];

                dp[index][targ] = take || dntTake;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totalSum / 2; s1++) {

            if (dp[n - 1][s1]) {

                int s2 = totalSum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }

        return mini;
    }

}