class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set= new HashSet<>(wordDict);
        
        int n=s.length();
        int [] dp= new int[n];


        Arrays.fill(dp, -1);

        return solve(0, s , set , dp);
    }

    public boolean solve(int index, String s, Set<String>set, int [] dp){

        if(index==s.length()){
            return true;
        }

        if(dp[index]!=-1){
            return dp[index]==1;
        }

        for(int next=index+1; next<=s.length(); next++){

            String word=s.substring(index, next);

            if(set.contains(word)){
                if(solve(next, s, set, dp)){
                    dp[index]=1;
                    return true;
                }
            }
        }

        dp[index]=0;
        return false;
    }
}