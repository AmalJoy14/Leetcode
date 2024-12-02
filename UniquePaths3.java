class Solution {
    int  paths = 0, emptySpace = 0;
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 0){
                    emptySpace++;
                }
                else if  (grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        move(startRow , startCol ,grid, 0);
        return paths;
    }
    public void move(int i , int j , int[][] grid , int empty){
        if (grid[i][j] == 2 && empty == emptySpace){
            paths++;
            return;
        }
        if (grid[i][j] < 0 || grid[i][j] == 2){
            return;
        }
        if (grid[i][j] == 1){
            grid[i][j] = -1;
        }
        if (grid[i][j] == 0){
            empty++;
            grid[i][j] = -2;
        }
        
        // System.out.println(i + " " + j + " " +empty);

        if (i < grid.length - 1) move(i+1 , j , grid , empty);
        if (i > 0) move(i-1 , j , grid , empty);
        if (j < grid[0].length - 1) move(i , j+1 , grid , empty);
        if (j > 0) move(i , j-1 , grid , empty);

        if (grid[i][j] == -2){
            empty--;
            grid[i][j] = 0;
        }
        
    }
}
