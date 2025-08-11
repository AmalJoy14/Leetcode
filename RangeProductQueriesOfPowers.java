class Solution {
    int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        long[] arr = new long[32];
        long val = 1;
        for(int i = 0 ; i < 32 ; i++){
            arr[i] = val;
            val *= 2;
        }
        ArrayList<Integer> powers = new ArrayList<>();
        for(int i = 31 ; i >= 0 ; i--){
            if(n >= arr[i]){
                powers.add((int)arr[i]);
                n -= arr[i];
            }
        }
        int j = powers.size() - 1;
        for(int i = 0 ; i < powers.size() / 2 ; i++){
            int temp = powers.get(i);
            powers.set(i , powers.get(j));
            powers.set(j , temp);
            j--;
        }
        //System.out.println(powers);
        
        //System.out.println(Arrays.toString(products));
        int len = queries.length;
        int[] res = new int[len];
        for(int i = 0 ; i < len ; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            long sub = 1;
            for(j = start ; j <= end ; j++){
                sub = (sub * powers.get(j)) % MOD;
            }
            res[i] = (int) sub;
        }
        return res;
    }
}
