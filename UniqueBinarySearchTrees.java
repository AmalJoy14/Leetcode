class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return findCount(n , dp);
    }
    public int findCount(int n , int[] dp){
        if(dp[n] != -1) return dp[n];
        if(n <= 1) return 1;
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += findCount(i - 1 , dp) * findCount(n - i , dp);
        }
        return dp[n] = sum;
    }
}
