class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr : dp) Arrays.fill(arr , - 1);

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                findCount(matrix , i , j , dp);
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                res += dp[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return res;
    }
    public int findCount(int[][] matrix , int i , int j ,int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] == 0){
            return dp[i][j] = 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int right = 0 , bottom = 0 , diagonal = 0;
        right = findCount(matrix , i , j + 1 ,dp);
        bottom = findCount(matrix , i + 1 , j ,dp);
        diagonal = findCount(matrix , i + 1 , j + 1 ,dp);
        return dp[i][j] = Math.min(diagonal , Math.min(right , bottom)) + 1;
    }
}
