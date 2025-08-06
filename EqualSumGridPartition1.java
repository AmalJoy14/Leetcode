class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                rowSum[i] += grid[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                colSum[i] += grid[j][i];
            }
        }
        //System.out.println(Arrays.toString(rowSum));
        long sum = 0;
        long[] suffixRowSum = new long[m];
        long[] suffixColSum = new long[n];
        for(int i = m - 1 ; i >= 0 ; i--){
            sum += rowSum[i];
            suffixRowSum[i] = sum;
        }
        
        sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            sum += colSum[i];
            suffixColSum[i] = sum;
        }
        //System.out.println(Arrays.toString(suffixColSum));
        sum = 0;
        for(int i = 0 ;i < m - 1 ; i++){
            sum += rowSum[i];
            if(suffixRowSum[i + 1] == sum) return true;
        }
        sum = 0;
        for(int i = 0 ;i < n - 1 ; i++){
            sum += colSum[i];
            if(suffixColSum[i + 1] == sum) return true;
        }
        return false;
    }
}
