class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <=m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <=n; j++) {
            dp[0][j] = j;
        }

        for (int index1 = 1; index1 <= m; index1++) {
            for (int index2 = 1; index2 <= n; index2++) {
                if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                }

                else {
                    dp[index1][index2] = 1 + Math.min(dp[index1-1][index2],
                            Math.min(dp[index1][index2 - 1], dp[index1 - 1][index2 - 1]));
                }

            }
        }

        return dp[m][n];

    }

}