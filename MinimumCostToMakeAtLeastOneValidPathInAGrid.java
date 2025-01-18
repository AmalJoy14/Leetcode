class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length , n = grid[0].length , cost = 0;
        int[][] weight = new int[m][n];
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        while(!que.isEmpty()){
            que.add(null);
            while(que.peek() != null){
                int[] temp = que.remove();
                if(cost != 0){
                    int i = temp[0] , j = temp[1];
                     if(j < grid[0].length - 1){
                        dfs(grid , weight , i , j+1 ,que);
                    }
                    if(j > 0){
                        dfs(grid , weight , i , j-1 ,que);
                    }
                    if(i < grid.length - 1){
                        dfs(grid , weight , i + 1 , j ,que);
                    }
                    if(i > 0){
                        dfs(grid , weight , i - 1 , j ,que);
                    }
                }
                dfs(grid , weight , temp[0] , temp[1] ,que);
            }
            que.remove();
            if(weight[m - 1][n - 1] == 1){
                return cost;
            }
            cost++;
        }
        return cost;
    }
    public void dfs(int[][] grid , int[][] weight , int i , int j ,Queue<int[]> que){
        if(weight[i][j] == 1){
            return;
        }
        que.add(new int[]{i , j});
        weight[i][j] = 1;
        if((grid[i][j] == 1) && j < grid[0].length - 1){
            dfs(grid , weight , i , j+1 ,que);
        }
        if((grid[i][j] == 2) && j > 0){
            dfs(grid , weight , i , j-1 ,que);
        }
        if((grid[i][j] == 3) && i < grid.length - 1){
            dfs(grid , weight , i + 1 , j ,que);
        }
        if((grid[i][j] == 4) && i > 0){
            dfs(grid , weight , i - 1 , j ,que);
        }
    }
}
