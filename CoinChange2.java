class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length - 1;
        int[][] dp = new int[amount + 1][n + 1];
    
        for (int i = 0 ; i <= n ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j <= n ; j++){
                
                int take = 0, nottake = 0;
                if(coins[j] <= i){
                    take = dp[i - coins[j] ][j];
                }
                if(j - 1 != -1)
                    nottake = dp[i][j - 1];
                dp[i][j] = take + nottake;
            }
        }
    
        return dp[amount][n];
    }
}
