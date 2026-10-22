class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        ArrayList<Integer> list= new ArrayList<>();
        

        for(int i=left; i<=right; i++){

            if(isSelfDiv(i)){
                list.add(i);
            }
        }

        return list;
    }

    public boolean isSelfDiv(int n){

        int original =n;

        while(n!=0){
            int digit=n%10;

            if(digit == 0 || original % digit !=0){
               return false;
            }
            n=n/10;
        }

        return true;

    }
}