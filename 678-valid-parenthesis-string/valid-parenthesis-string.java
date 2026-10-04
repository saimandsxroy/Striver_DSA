class Solution {
    public boolean checkValidString(String s) {
        
        int minBalance=0;
        int maxBalance=0;


        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);


            if(ch=='('){
                minBalance++;
                maxBalance++;

            }else if(ch==')'){
                minBalance--;
                maxBalance--;
            }

            else{
                maxBalance++;
                minBalance--;

            }

        if(maxBalance<0){
            return false;
        }

        minBalance=Math.max(0,minBalance);

        }
        return minBalance==0;
    }
}