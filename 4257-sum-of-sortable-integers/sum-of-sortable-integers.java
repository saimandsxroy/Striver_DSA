class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && isSortable(nums, k)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int breaks = 0;

        
            for (int i = start; i <= end; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);

                int next = (i == end) ? start : i + 1;

                if (nums[i] > nums[next]) {
                    breaks++;
                }
            }

         
            if (breaks > 1) {
                return false;
            }

        
            if (prevMax > min) {
                return false;
            }

            prevMax = max;
        }

        return true;
    }
}