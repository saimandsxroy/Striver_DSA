class Solution {
    public int countPrimes(int n) {


        if(n<=1){
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        Arrays.fill(isPrime, true);



        if (n > 0) {
            isPrime[0] = false;
        }

        if (n > 1) {
            isPrime[1] = false;
        }

        int i = 2;

        while (i * i <= n) {

            if (isPrime[i]) {
                for (int j = i * i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
            i++;
        }


        int count=0;

        for(int j=2; j<n; j++){
            if(isPrime[j]){
                count++;
            }
        }


        return count;

    }
}