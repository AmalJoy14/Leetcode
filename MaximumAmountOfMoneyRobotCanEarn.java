class Solution {
    
    public int maximumAmount(int[][] coins) {
        int m = coins.length , n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        int res = findPaths(coins , 0 , 0 , 2  , dp);
        return res;
    }

    public int findPaths(int[][] coins ,int i ,int j, int saver , int[][][] dp){
        if(i == coins.length - 1 && j == coins[0].length - 1){
            
            return coins[i][j] >= 0 ? coins[i][j] : (saver > 0 ? 0 : coins[i][j]) ;
        }
        if(dp[i][j][saver] != -1){
            return dp[i][j][saver];
        }
        
        int down = Integer.MIN_VALUE , right = Integer.MIN_VALUE;
        //Down
        if(i < coins.length - 1){
            down = findPaths(coins , i + 1 , j , saver , dp) + coins[i][j];
        }

        //Right
        if(j < coins[0].length - 1){
            right = findPaths(coins , i , j + 1 , saver , dp) + coins[i][j];
        }
        
        int down2 = Integer.MIN_VALUE , right2 = Integer.MIN_VALUE;
        if(saver > 0 && coins[i][j] < 0){
            
            //Down
            if(i < coins.length - 1){
                down2 = findPaths(coins , i + 1 , j , saver - 1 ,dp);
            }
    
            //Right
            if(j < coins[0].length - 1){
                right2 = findPaths(coins , i , j + 1 , saver - 1,dp);
            }
        }
        
        dp[i][j][saver] = Math.max(Math.max(right , down) , Math.max(down2 , right2));
        return dp[i][j][saver];
    }
}
