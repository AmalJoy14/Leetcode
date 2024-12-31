class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 1; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(i == m - 1 && j == n - 1) continue;
                int down = Integer.MAX_VALUE , right = Integer.MAX_VALUE;
                if(i < m - 1){
                    down = dp[i + 1][j];
                }
                if(j < n - 1){
                    right = dp[i][j + 1];
                }
                dp[i][j] = grid[i][j] + Math.min(right , down);
            }
        }
        return dp[0][0];
    }
}
