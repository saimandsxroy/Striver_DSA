class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m= text1.length();
        int n=text2.length();


        int [][] dp= new int[m][n];

        for(int i=0; i<m ;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(m-1, n-1, dp, text1, text2);
    }

    
    public int solve(int index1, int index2, int [][] dp, String text1, String text2){

        if(index1<0 || index2<0){
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2]=1+solve(index1-1, index2-1, dp, text1, text2);
        }


        return dp[index1][index2]=Math.max(solve(index1-1, index2, dp, text1, text2) , solve(index1, index2-1, dp, text1, text2));

    }

}