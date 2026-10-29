class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> list= new ArrayList<>(map.values());

        Collections.sort(list, (a,b)-> Integer.compare(b,a));

        int removed = 0;
        int setSize = 0;
        int target = (arr.length + 1) / 2;


        for (int freq : list) {
            removed += freq;
            setSize++;

            if (removed >= target) {
                return setSize;
            }
        }

        return setSize;

    }
}