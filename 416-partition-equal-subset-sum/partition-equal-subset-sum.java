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

        boolean[] prev = new boolean[target + 1];

        for (int index = 0; index < n; index++) {
            prev[0] = true;
        }

        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {

            boolean [] curr= new boolean[target+1];

            for (int targ = 1; targ <= target; targ++) {

                boolean take = false;

                if (nums[index] <= targ) {
                    take = prev[targ-nums[index]];
                }

                boolean dntTake = prev[targ];

                curr[targ]= take || dntTake;
            }
            prev=curr;
        }

        return prev[target];

    }

    
}