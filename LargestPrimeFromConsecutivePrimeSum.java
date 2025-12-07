class Solution {
    public int largestPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime , true);
        
        for(int i = 3 ; i <= n ; i += 2){
            for(int j = i * 2 ; j <= n ; j += i){
                isPrime[j] = false;
            }
        }
        Set<Long> set = new HashSet<>();
        long sum = 2;
        set.add(sum);
        for(int i = 3 ; i <= n ; i+=2){
            if(isPrime[i]){
                sum += i;
                set.add(sum);
            }
        }
        //System.out.println(set);
        for(long i = n ; i > 1; i--){
            if(i == 2) return 2;
            if(i % 2 == 0) continue;
            if(set.contains(i) && isPrime[(int)i]) return (int)i;
        }
        return 0;
    }
}
