class Solution {
    int pacificReached = 0 , atlanticReached = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int m = heights.length , n = heights[0].length;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                pacificReached = 0 ;
                atlanticReached = 0;
                findRoute(i , j , heights);
                if (pacificReached == 1 && atlanticReached == 1){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    list.add(sub);
                }
            }
        }
        return list;
    }

    public void findRoute(int i , int j , int[][]grid){
        if (pacificReached == 1 && atlanticReached == 1){
            return;
        }
        if (i == 0 || j == 0){
            pacificReached = 1;
        }
        if (i == grid.length - 1 || j == grid[0].length - 1){
            atlanticReached = 1;
        }
        
        // System.out.println(i + "  " + j);
        
        int temp = grid[i][j];

        if (i > 0 && grid[i - 1][j] <= grid[i][j]){
            grid[i][j] = Integer.MAX_VALUE;
            findRoute(i - 1 , j , grid);
            grid[i][j] = temp;
        }
        if (i < grid.length - 1 && grid[i + 1][j] <= grid[i][j]){
            grid[i][j] = Integer.MAX_VALUE;
            findRoute(i + 1 , j , grid);
            grid[i][j] = temp;
        }
        if (j > 0 && grid[i][j - 1] <= grid[i][j]){
            grid[i][j] = Integer.MAX_VALUE;
            findRoute(i , j - 1, grid);
            grid[i][j] = temp;
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] <= grid[i][j]){
            grid[i][j] = Integer.MAX_VALUE;
            findRoute(i , j + 1, grid);
            grid[i][j] = temp;
        }
    } 
}
