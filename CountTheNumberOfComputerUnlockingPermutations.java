class Solution {
    int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long res = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(complexity[i] <= complexity[0]) return 0;
        }

        
        for(int i = 1 ; i < n ; i++){
            //System.out.println(count);
            res = ((long)res * i) % MOD;
        }
        return (int)res;
    }
}
