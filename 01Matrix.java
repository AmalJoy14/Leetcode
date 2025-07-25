class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        int m = mat.length , n = mat[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i , j , 0});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] directions = new int[][]{{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};

        while(!que.isEmpty()){
            int[] arr = que.remove();
            
            for(int k = 0 ; k < 4 ; k++){
                int i = arr[0] , j = arr[1] , val = arr[2] + 1;
                i += directions[k][0];
                j += directions[k][1];
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1) continue;
                visited[i][j] = 1;
                mat[i][j] = val;
                que.add(new int[]{i , j , val});
            }
            
        }
        return mat;
    }
}
