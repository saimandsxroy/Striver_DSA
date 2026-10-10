class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] curr= new int [n + 1];


        for (int index = n - 1; index >= 0; index--) {

            int [] temp=new int[n+1];

            for (int prev = 0; prev <= index; prev++) {

                int take = Integer.MIN_VALUE;

                if (prev == 0 || nums[index] > nums[prev-1]) {
                    take = 1 + curr[index+1];
                }

                int dntTake = curr[prev];

                int maxi = Math.max(take, dntTake);

                temp[prev] = maxi;
            }
            curr=temp;
        }


        return curr[0];

    }

}