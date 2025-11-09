class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;
        int[][][] dp = new int[m][n][1001];
        for(int[][] mat : dp){
            for(int[] arr : mat)
                Arrays.fill(arr , -1);
        }
        
        int res = findMax(grid , 0 , 0 , 0 , k , dp);
        return res < 0 ? -1 : res;
    }
    public int findMax(int[][] grid , int i , int j , int cost, int k , int[][][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        int currCost = cost + (grid[i][j] == 0 ? 0 : 1);
        if(currCost > k) return dp[i][j][currCost] = Integer.MIN_VALUE;

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j][currCost] != -1) return dp[i][j][currCost];


        int down = findMax(grid , i + 1, j , currCost, k , dp);
        int right = findMax(grid , i, j + 1 , currCost, k , dp);
        if(down == Integer.MIN_VALUE && right == Integer.MIN_VALUE) return dp[i][j][currCost] = Integer.MIN_VALUE;
        return dp[i][j][currCost] = Math.max(down , right) + grid[i][j];
    }
}
