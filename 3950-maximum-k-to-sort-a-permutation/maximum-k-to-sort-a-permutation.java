class Solution {
    public int sortPermutation(int[] nums) {

        int n = nums.length;

        int ans = 0;
        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (nums[i] != i) {
                if (!found) {
                    ans = nums[i];
                    found = true;
                } else {
                    ans &= nums[i];
                }
            }
        }

        return found ? ans : 0;
    }
}