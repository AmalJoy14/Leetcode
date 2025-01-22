class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length ,n = isWater[0].length; 
        int[][] map = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(map[i] , -1);
        }
        Queue<int[]> que = new LinkedList<>(); 
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isWater[i][j] == 1){
                    map[i][j] = 0;
                    que.add(new int[]{i , j});
                }
            }
        }
        
        while(!que.isEmpty()){
            int[] temp = que.remove();
            int i = temp[0];
            int j = temp[1];

            //Top
            if(i > 0 && map[i - 1][j] == -1){
                map[i - 1][j] = map[i][j] + 1;
                que.add(new int[]{i- 1, j});
            }
            //Down
            if(i < m - 1 && map[i + 1][j] == -1){
                map[i + 1][j] = map[i][j] + 1;
                que.add(new int[]{i + 1, j});
            }
            //Left
            if(j > 0 && map[i][j - 1] == -1){
                map[i][j - 1] = map[i][j] + 1;
                que.add(new int[]{i, j - 1});
            }
            //Right
            if(j < n - 1 && map[i][j + 1] == -1){
                map[i][j + 1] = map[i][j] + 1;
                que.add(new int[]{i, j + 1});
            }
        }
        return map;
    }
}
