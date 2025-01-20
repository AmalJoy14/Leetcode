class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length , n = mat[0].length;
        int[] rowIdx = new int[m*n];
        int[] colIdx = new int[n*m];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                rowIdx[mat[i][j] - 1] = i;
                colIdx[mat[i][j] - 1] = j;
            }
        }
        int[] rowfilled = new int[m];
        int[] colfilled = new int[n];
        for(int i = 0 ; i < arr.length ;i++){
            rowfilled[rowIdx[arr[i] - 1]]++;
            colfilled[colIdx[arr[i] - 1]]++;
            if(rowfilled[rowIdx[arr[i] - 1]] == n || colfilled[colIdx[arr[i]- 1]] == m){
                return i;
            }
        }
        return -1;
    }
}
