class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    int sum = findSum(grid , i , j);
                    //System.out.println(sum);
                    if(sum % k == 0) count++;
                }
            }
        }
        return count;
    }

    public int findSum(int[][] grid , int i , int j){
        if(grid[i][j] == 0){
            return 0;
        }
        int sum = 0;
        sum += grid[i][j];
        grid[i][j] = 0;
        int left = 0 , right = 0 , bottom = 0 , top = 0;
        if(j > 0)
            left = findSum(grid ,i , j - 1);
        if(j < grid[0].length - 1)
            right = findSum(grid , i , j + 1);
        if(i > 0)
            top = findSum(grid , i  - 1 , j );
        if(i < grid.length - 1)
            bottom = findSum(grid , i + 1 , j);
        sum += left + right + top + bottom ;
        return sum;
    }
}
