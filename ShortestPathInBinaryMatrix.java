class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0 , 0 , 1});

        int[][] directions = new int[][]{{1 , 0} , {-1 , 0} , {0 ,1} , {0 , -1} , {-1 , -1} ,{1 , 1} , {1 , -1} , {-1 , 1}};
        int[][] visited = new int[m][n];

        while(!que.isEmpty()){
            int[] arr = que.remove();
            if(arr[0] == m - 1 && arr[1] == n - 1) return arr[2];
            for(int k = 0 ; k < 8 ; k++){
                int i = arr[0] + directions[k][0];
                int j = arr[1] + directions[k][1];
                int val = arr[2] + 1; 
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1) continue;
                visited[i][j] = 1;
                if(grid[i][j] == 1) continue;
                que.add(new int[]{i , j , val});
            }
        }
        return -1;
    }
}
