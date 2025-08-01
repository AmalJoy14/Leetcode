class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int curr = 1 , i = 0 , j = 0;
        mat[i][j] = 1;

        while(curr < n * n){
            while(j < mat[0].length - 1 && mat[i][j + 1] == 0){
                j++;
                curr++;
                mat[i][j] = curr; 
            }
            while(i < mat.length - 1 && mat[i + 1][j] == 0){
                i++;
                curr++;
                mat[i][j] = curr; 
            }
            while(j > 0 && mat[i][j - 1] == 0){
                j--;
                curr++;
                mat[i][j] = curr; 
            }
            while(i > 0 && mat[i - 1][j] == 0){
                i--;
                curr++;
                mat[i][j] = curr; 
            }
        }
        return mat;
    }
}
