class Solution {
    int max = 0 , size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == 1){
                    size = 0;
                    sinkIsland(grid , i , j);
                }
            }
        }
        return max;
    }

    public void sinkIsland(int[][] grid , int p , int q ){
        if (grid[p][q] == 0){
            return;
        }
        size++;
        max = Math.max(max ,size);
        grid[p][q] = 0;

        //Top
        if (p != 0){
            sinkIsland(grid , p - 1 , q );
        }
        //Bottom
        if (p != grid.length - 1){
            sinkIsland(grid , p + 1 , q);
        }
        //Left
        if (q != 0){
            sinkIsland(grid , p , q - 1);
        }
        //Right
        if (q != grid[0].length - 1){
            sinkIsland(grid , p , q + 1);
        }
    }
}
