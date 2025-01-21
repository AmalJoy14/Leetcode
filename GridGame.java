class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] prefix = new long[2][n + 2];
        long sum1 = 0 , sum2 = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            sum1 += grid[0][i];
            prefix[0][i + 1] = sum1;
        }
        for(int i = 0 ; i < n ; i++){
            sum2 += grid[1][i];
            prefix[1][i + 1] = sum2;
        }
        // System.out.println(Arrays.toString(prefix[0]));
        // System.out.println(Arrays.toString(prefix[1]));

        long min = Long.MAX_VALUE;
        long topArr = Long.MAX_VALUE, bottomArr = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n; i++){
            bottomArr = prefix[1][i - 1];
            topArr = prefix[0][i + 1];
            min =Math.min(min , Math.max(topArr ,bottomArr));
        }
        return min;
        
    }
}
