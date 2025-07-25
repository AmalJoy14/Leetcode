class Solution {
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000000 , res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(hasPath(heights , mid)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean hasPath(int[][] heights , int num){
        int m = heights.length , n = heights[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0 , 0});

        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        int[][] directions = new int[][]{{-1, 0} , {1 , 0} , { 0, 1} , {0, -1}};

        while(!que.isEmpty()){
            int[] arr = que.remove();
            for(int k = 0 ; k < 4 ;k++){
                int i = arr[0] + directions[k][0];
                int j = arr[1] + directions[k][1];
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1) continue;
                if(Math.abs(heights[i][j] - heights[arr[0]][arr[1]]) > num) continue;
                visited[i][j] = 1;
                que.add(new int[]{i , j});
            }
        }
        return visited[m - 1][n - 1] == 1;
    }
}
