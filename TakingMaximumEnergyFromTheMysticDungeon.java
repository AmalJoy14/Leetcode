class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            res = Math.max(res , findMax(energy , i , dp , k));
        }
        return res;
    }
    public int findMax(int[] energy , int i , int[] dp , int k){
        if(i >= energy.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        return dp[i] = findMax(energy , i + k , dp , k) + energy[i];
    }
}
