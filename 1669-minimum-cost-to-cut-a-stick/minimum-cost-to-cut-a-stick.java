class Solution {
    public int minCost(int n, int[] cuts) {

        int c = cuts.length;

        int[][] dp = new int[c + 2][c + 2];

        int[] arr = new int[c + 2];

        arr[0] = 0;
        arr[c + 1] = n;

        for (int i = 0; i < c; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        for (int start = c; start >= 1; start--) {
            for (int end = start; end <= c; end++) {

                if (start > end) {
                    continue;
                }

                int mini = Integer.MAX_VALUE;

                for (int k = start; k <= end; k++) {

                    int cost = arr[end + 1] - arr[start - 1] + dp[start][k-1] + dp[k+1][end];

                    mini = Math.min(mini, cost);
                }

                 dp[start][end] = mini;

            }
        }

        return dp[1][c];

    }
}