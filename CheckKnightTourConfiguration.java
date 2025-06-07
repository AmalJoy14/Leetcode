class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return travel(grid , 0 , 0, 0);
    }
    public boolean travel(int[][] grid , int i , int j , int val){
        if(grid[i][j] == (int)(grid.length * grid.length) - 1){
            return true;
        }
        if(i - 2 >= 0 && j - 1 >= 0 && grid[i - 2][j - 1] == val + 1){
            return travel(grid , i - 2 , j - 1 , val + 1);
        }
        else if(i - 1 >= 0 && j - 2 >= 0 && grid[i - 1][j - 2] == val + 1){
            return travel(grid , i - 1 , j - 2 , val + 1);
        }
        else if(i + 1 < grid.length && j - 2 >= 0 && grid[i + 1][j - 2] == val + 1){
            return travel(grid , i + 1 , j - 2 , val + 1);
        }
        else if(i + 2 < grid.length && j - 1 >= 0 && grid[i + 2][j - 1] == val + 1){
            return travel(grid , i + 2 , j - 1 , val + 1);
        }//////
        else if(i - 2 >= 0 && j + 1 < grid.length && grid[i - 2][j + 1] == val + 1){
            return travel(grid , i - 2 , j + 1 , val + 1);
        }
        else if(i - 1 >= 0 && j + 2 < grid.length && grid[i - 1][j + 2] == val + 1){
            return travel(grid , i - 1 , j + 2 , val + 1);
        }
        else if(i + 1 < grid.length && j + 2 < grid.length && grid[i + 1][j + 2] == val + 1){
            return travel(grid , i + 1 , j + 2 , val + 1);
        }
        else if(i + 2 < grid.length && j + 1 < grid.length && grid[i + 2][j + 1] == val + 1){
            return travel(grid , i + 2 , j + 1 , val + 1);
        }
        return false;
    }
}
