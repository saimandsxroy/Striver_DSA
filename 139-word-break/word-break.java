class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        int[] dp = new int[n + 1];

         dp[n]=1;

        
        for (int index= s.length()-1; index>=0; index--) {

            for(int next=index+1; next<=s.length(); next++){
                 String word = s.substring(index, next);

            if (set.contains(word) && dp[next]==1) {
                dp[index]=1;
                break;
            }

            }

           
        }

       return dp[0]==1;


    }

}