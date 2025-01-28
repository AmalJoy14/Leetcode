class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    max = Math.max(calculateMax( i , j , grid), max);
                }
            }
        }
        return max;
    }
    public int calculateMax(int i  , int j , int[][] grid){
        if(grid[i][j] == 0){
            return 0;
        }
        int val =  grid[i][j];
        grid[i][j] = 0;
        int top = 0 , down = 0, left = 0 , right = 0;
        if(i > 0)
            top = calculateMax(i - 1 , j , grid);
        if(i < grid.length - 1) 
            down = calculateMax(i + 1 , j , grid);
        if(j > 0)
            left = calculateMax(i , j - 1 , grid);
        if(j < grid[0].length - 1)
            right = calculateMax(i , j + 1, grid);
        val += left + right + top + down;
        return val;
    }
}
