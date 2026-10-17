class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];


        for (int j = 0; j <=n; j++) {
            prev[j] = j;
        }

        for (int index1 = 1; index1 <= m; index1++) {

            int [] curr= new int[n+1];

            curr[0]=index1;

            for (int index2 = 1; index2 <= n; index2++) {
                if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
                    curr[index2] =prev[index2 - 1];
                }

                else {
                    curr[index2] = 1 + Math.min(prev[index2],
                            Math.min(curr[index2 - 1], prev[index2 - 1]));
                }

            }

            prev=curr;
        }

        return prev[n];

    }

}