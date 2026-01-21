class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0, n = matrix.length , flag = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 0) flag = 1;
                if(matrix[i][j] < 0) {
                    count++;
                }
                min = Math.min(Math.abs(matrix[i][j]) , min);
                sum += Math.abs(matrix[i][j]);
            }
        }
        
        if(count % 2 == 0 || flag == 1){
            min = 0;
        }
        return sum - 2 * min;
    }
}
