class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        int n = grid.length;
        int m = grid[0].length;

        for(int i =0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                pq.add(new int[]{grid[i][j] , i});
            }
        }
        long res = 0;
        while(k > 0){
            int[] arr = pq.poll();
            if(limits[arr[1]] > 0 ){
                limits[arr[1]]--;
                res += arr[0];
                k--;
            }
        }
        return res;
    }
}
