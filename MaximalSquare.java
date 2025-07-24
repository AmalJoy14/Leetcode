class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0, m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                int side = findMax(matrix , i , j , dp);
                res = Math.max(side * side , res);
            }
        }
        return res;
    }

    public int findMax(char[][] matrix , int i , int j , int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length ){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(matrix[i][j] == '0'){
            return dp[i][j] = 0;
        }
        int right = 0 , diagonal = 0 , bottom = 0;
        right = findMax(matrix , i , j + 1 , dp);
        diagonal = findMax(matrix , i + 1 , j + 1 ,dp);
        bottom = findMax(matrix , i + 1 , j ,dp);

        return dp[i][j] = Math.min(right , Math.min(diagonal , bottom)) + 1;
    }
}
