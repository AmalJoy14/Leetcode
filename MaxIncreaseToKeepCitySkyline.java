class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, sum = 0;

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                int maxRow = 0 , maxCol = 0;
                for (int k = 0 ; k < n ; k++){
                    if (grid[i][k] > maxRow){
                        maxRow = grid[i][k];
                    }
                }
                for (int k = 0 ; k < n ; k++){
                    if (grid[k][j] > maxCol){
                        maxCol = grid[k][j];
                    }
                }
                sum += Math.abs(Math.min(maxCol , maxRow) - grid[i][j]);
            }
        }
        return sum;
    }
}
