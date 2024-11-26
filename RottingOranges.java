class Solution {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int m = grid.length, n = grid[0].length;

        int flag = 0;

        while(flag == 0){
            flag = 1;
            min++;
            for (int i = 0 ; i < m ; i++){
                for (int j = 0 ; j < n ; j++){
                    if (grid[i][j] == 2){
                        roteOranges(i , j , grid);
                    }
                }
            }

            //Convert currently rotted to rotted
            for (int i = 0 ; i < m ; i++){
                for (int j = 0 ; j < n ; j++){
                    if (grid[i][j] == 3){
                        flag = 0;
                        grid[i][j] = 2;
                    }
                }
            }

        }
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if  (grid[i][j] == 1) return -1;
            }
        }
        return min - 1;
    }

    public void roteOranges(int i , int j , int[][] grid){
        //3 stands for currently rotted
        if (i > 0 && grid [i - 1][j] == 1){
            grid[i - 1][j] = 3;
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1){
            grid[i + 1][j] = 3;
        }
        if (j > 0 && grid[i][j - 1] == 1){
            grid[i][j - 1] = 3;
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1){
            grid[i][j + 1] = 3;
        }
    }
}
