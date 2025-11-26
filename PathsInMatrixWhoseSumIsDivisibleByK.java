class Solution {
    int MOD = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][] mat : dp){
            for(int[] arr : mat)
                Arrays.fill(arr , -1);
        }
        return (int)findCount(grid , 0, 0 , k , 0 , dp);
    }
    public long findCount(int[][] grid , int i , int j , int k , int sum , int[][][] dp){
        int m = grid.length , n = grid[0].length;
        if(i >= m || j >= n){
            return 0;
        }
        sum += grid[i][j];
        if(i == m - 1 && j == n - 1 && sum % k == 0){
            return 1;
        }
        if(dp[i][j][sum % k] != -1){
            return dp[i][j][sum % k];
        }
        long right = findCount(grid , i , j + 1 , k , sum % k , dp);
        long down = findCount(grid , i + 1 , j , k , sum % k , dp);
        return dp[i][j][sum % k] =(int) (right + down) % MOD;
    }
}
