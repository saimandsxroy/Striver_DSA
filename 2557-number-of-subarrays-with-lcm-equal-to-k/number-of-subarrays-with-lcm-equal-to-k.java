class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int count=0;

        for(int i=0; i<nums.length; i++){
            int currLcm= nums[i];

            for(int j=i; j<nums.length; j++){
                currLcm=lcm(currLcm, nums[j]);


                if(currLcm>k || k%currLcm != 0){
                    break;
                }

                if(currLcm==k){
                    count++;
                }
            }

    
        }

        return count;
    }


    public int lcm(int a, int b){
        int greatestComman=gcd(a,b);
        return (a*b)/greatestComman;
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