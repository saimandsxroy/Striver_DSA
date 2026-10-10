class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n=nums1.length; 

        int [] diff=new int [n];
        
        int maxDiff=0;

        int i=0;
        int j=0;

        while(i<n && j<n){
            diff[i]=Math.abs(nums1[i]-nums2[i]);

            maxDiff=Math.max(maxDiff, diff[i]);

            i++;
            j++;
        }


        int [] freq= new int[maxDiff+1];

        for(int d : diff){
            freq[d]++;
        }
        
        long  k= (long) k1+k2;

        for(int d=maxDiff; d>0 && k>0 ; d--){

            if(freq[d]==0){
                continue;
            }

            if(k>=freq[d]){
                k-=freq[d];
                freq[d-1]+=freq[d];
                freq[d]=0;
            }else{
                int moves=(int)k;
                freq[d]-=moves;
                freq[d-1]+=moves;
                k=0;
            }
        }


        long answer=0;

        for(int d=0; d<freq.length; d++){
            answer+=(long) d * d * freq[d];
        }

        return answer;



    }
}