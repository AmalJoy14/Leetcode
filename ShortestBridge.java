class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        int n = grid.length, flag = 0;
        int[][] visited = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    dfs(grid , i , j , que, visited);
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) break;
        }
        int[][] directions = new int[][]{{-1, 0} , {1 , 0} , {0 , -1} , {0 , 1}};
        while(!que.isEmpty()){
            int[] arr = que.remove();
            for(int[] dir : directions){
                int x = arr[0] + dir[0];
                int y = arr[1] + dir[1];
                int val = arr[2] + 1;
                if(x < 0 || y < 0 || x >= n || y >= n || visited[x][y] == 1) continue;

                visited[x][y] = 1;
                if(grid[x][y] == 1) return arr[2];
                que.add(new int[]{x , y , val});
            }
        }
        return -1;
    }
    public void dfs(int[][] grid , int i , int j , Queue<int[]> que , int[][] visited){
        int n = grid.length;
        if(i < 0 || j < 0 || i >= n || j >= n) return;
        if(visited[i][j] == 1 || grid[i][j] == 0) return;

        visited[i][j] = 1;
        que.add(new int[]{i , j, 0});
        dfs(grid , i + 1, j , que , visited);
        dfs(grid , i - 1, j , que , visited);
        dfs(grid , i , j + 1, que , visited);
        dfs(grid , i , j - 1, que , visited);
    }
}
