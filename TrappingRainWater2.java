class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length , n = heightMap[0].length;
        int[][] visited = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        for(int i = 0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                if(i == 0 || j == 0 || i == m - 1 || j== n - 1){
                    visited[i][j] = 1;
                    pq.add(new int[]{heightMap[i][j] , i , j});
                }
            }
        }
        int total = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int h = arr[0];
            int i = arr[1];
            int j = arr[2];
            if(i > 0 && visited[i - 1][j] == 0){
                if(heightMap[i - 1][j] < heightMap[i][j]){
                    total += heightMap[i][j] - heightMap[i - 1][j];
                    heightMap[i - 1][j] = heightMap[i][j];
                }
                pq.add(new int[]{heightMap[i - 1][j] , i - 1 , j});
                visited[i - 1][j] = 1;
            }
            if(j > 0 && visited[i][j - 1] == 0){
                if(heightMap[i][j - 1] < heightMap[i][j]){
                    total += heightMap[i][j] - heightMap[i][j - 1];
                    heightMap[i][j - 1] = heightMap[i][j];
                }
                pq.add(new int[]{heightMap[i][j - 1] , i , j - 1});
                visited[i][j - 1] = 1;
            }
            if(j < n - 1  && visited[i][j + 1] == 0){
                if(heightMap[i][j + 1] < heightMap[i][j]){
                    total += heightMap[i][j] - heightMap[i][j + 1];
                    heightMap[i][j + 1] = heightMap[i][j];
                }
                pq.add(new int[]{heightMap[i][j + 1] , i , j + 1});
                visited[i][j + 1] = 1;
            }
            if(i < m - 1  && visited[i + 1][j] == 0){
                if(heightMap[i + 1][j] < heightMap[i][j]){
                    total += heightMap[i][j] - heightMap[i + 1][j];
                    heightMap[i + 1][j] = heightMap[i][j];
                }
                pq.add(new int[]{heightMap[i + 1][j] , i + 1 , j});
                visited[i + 1][j] = 1;
            }
        }
        return total;
    }
}
