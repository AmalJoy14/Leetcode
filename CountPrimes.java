class Solution {
    public int countPrimes(int n) {
        
        //Sieve Of Eratosthenes.
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes , true);    //Default : true
        int count = 0;

        for (int i = 2 ; i < n ; i++){
            if (isPrimes[i]){
                count++;
                for (int j = i * 2 ; j < n ; j += i){
                   isPrimes[j] = false; 
                }
            }
        }

        return count;
    }
}
