class Solution {
    int count = 0;
    final int MOD = 1_000_000_007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][32];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return findPaths(grid, 0, 0, 0, k , dp);
    }

    public int findPaths(int[][] grid, int i, int j, int val, int k, int[][][] dp) {
        val = val ^ grid[i][j];
        if(dp[i][j][val] != -1){
            return dp[i][j][val];
        }
        
        if (i == grid.length - 1 && j == grid[0].length - 1 && val == k) {
            return 1;
        }

        int right = 0, down = 0;
        if (j < grid[0].length - 1)
            right = findPaths(grid, i, j + 1, val, k ,dp);

        if (i < grid.length - 1)
            down = findPaths(grid, i + 1, j, val, k ,dp);

        dp[i][j][val] =  (right + down) % MOD;
        return dp[i][j][val];
    }
}
