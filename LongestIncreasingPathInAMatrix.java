class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        int res = 0;
        for(int i = 0 ;i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int max = findMax(i , j , matrix , dp);
                if(max > res) res = max;
            }
        }
        return res;
    }

    public int findMax(int i , int j , int[][] matrix , int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left = 0 , right = 0 , bottom = 0 , top = 0;
        if(i > 0 && matrix[i - 1][j] > matrix[i][j]){
            top = findMax(i - 1 , j , matrix , dp);
        }
        if(i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]){
            bottom = findMax(i + 1 , j , matrix , dp);
        }
        if(j > 0 && matrix[i][j - 1] > matrix[i][j]){
            left = findMax( i , j - 1 , matrix , dp);
        }
        if(j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]){
            right = findMax(i , j + 1 , matrix , dp);
        }
        return dp[i][j] = Math.max(left , Math.max(right , Math.max(top , bottom))) + 1;
    }
}
