class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length; 

        int [] dp= new int[n];

        int [] parent =new int[n];


        Arrays.fill(dp, 1);

        int maxi=1;
        int lastIndex=0;

         Arrays.sort(nums);

        for(int i=0; i<n; i++){

            parent[i]=i;

            for(int prev=0; prev<i; prev++){

                if(nums[i] % nums[prev] == 0 && dp[prev]+1 > dp[i]){
                    dp[i]=dp[prev]+1;
                    parent[i]=prev;
                }
            }


            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }


        ArrayList <Integer> list= new ArrayList<>();

        while(true){
            list.add(nums[lastIndex]);

            if(parent[lastIndex]==lastIndex){
                break;
            }

            lastIndex=parent[lastIndex];

        }

        return list;

    }
}