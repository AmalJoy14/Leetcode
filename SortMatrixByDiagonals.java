class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for(int i = 0 ; i < n ; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int l = i;
            for(int j = 0 ; j < n && l < n; j++){
                pq.add(grid[l][j]);
                l++;
            }
            // System.out.println(pq);
            int k = i;
            int j = 0;
            while(!pq.isEmpty()){
                grid[k][j] = pq.poll();
                k++;
                j++;
            }
            
        }

        for(int j = 1 ; j < n ; j++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int l = j;
            for(int i = 0 ; i < n && l < n; i++){
                pq.add(grid[i][l]);
                l++;
            }
            int i = 0;
            int k = j;
            while(!pq.isEmpty()){
                grid[i][k] = pq.poll();
                i++;
                k++;
            }
        }
        return grid;
    }
}
