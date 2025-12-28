class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int j = n - 1 , res = 0;
        for(int i = 0 ; i < m ; i++){
            while(j >= 0 && grid[i][j] < 0){
                j--;
            }
            res += n - 1 - j;
        }
        return res;
    }
}
