class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0 , j = 0 , m = mat.length , n = mat[0].length , k = 0;
        int[] res = new int[m * n];
        while( k < m * n){
            while(i >= 0 && j < n){
                res[k] = mat[i][j];
                i--;
                j++;
                k++;
            }
            i++;
            j--;
            if(j < n - 1) j++;
            else i++;
            while(i < m && j >= 0){
                res[k] = mat[i][j];
                i++;
                j--;
                k++;
            }
            i--;
            j++;
            if(i < m - 1) i++;
            else j++;
        }
        return res;   
    }
}
