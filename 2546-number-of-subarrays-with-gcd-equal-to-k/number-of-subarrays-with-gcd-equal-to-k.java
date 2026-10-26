class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n=nums.length;

        int count=0;
        
        for(int i=0; i<n; i++){
            int currGcd=0;
            for(int j=i; j<n; j++){
               
               currGcd=gcd(currGcd, nums[j]);

               if(currGcd==k){
                count++;
               }
            }
        }

        return count;

    
    }

    public int gcd(int a, int b){

        while(a!=0){
            int temp=a;
            a=b%a;
            b=temp;
        }
        return b;
    }
}