class Solution {
    public boolean isPalindrome(String s) {

        String ans=intoLowerAndNonAlpha(s);
        
        int start=0; 
        int end=ans.length()-1;

        while(start<=end){

            if(ans.charAt(start)!=ans.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;

    }

    public String intoLowerAndNonAlpha(String s){

        StringBuilder ans= new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                ans.append(Character.toLowerCase(ch));
            }
        }
        return ans.toString();
    }
}