class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        return n1-longestComanPalindrome(word1, word2) + n2-longestComanPalindrome(word1,word2);
    }
    public int longestComanPalindrome(String word1, String word2){

        int m=word1.length();
        int n=word2.length();

        int [][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}