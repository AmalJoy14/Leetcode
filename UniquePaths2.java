class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1; 
        for(int i = m - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0; j--){
                if(i == m - 1 && j == n - 1 || obstacleGrid[i][j] == 1) continue;
                int down = 0 , right = 0;
                if(i < m - 1){
                    down = dp[i + 1][j];
                }
                if(j < n - 1){
                    right = dp[i][j + 1];
                }
                dp[i][j] = down + right;  
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}
