class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[][] horDp = new int[m][n];
        for(int[] arr : horDp) Arrays.fill(arr , -1);
        int[][] verDp = new int[m][n];
        for(int[] arr : verDp) Arrays.fill(arr , -1);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                findMax1(i , j , grid ,horDp);
                findMax2(i , j , grid , verDp);
            }
        }
        int res = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int len = horDp[i][j] ; len > 0 ; len--){
                    if((i + len - 1) < m && (horDp[i + len - 1][j] >= len) && 
                        verDp[i][j] >= len && (j + len - 1) < n && verDp[i][j + len - 1] >= len){
                        res = Math.max(res , len * len);
                    }
                }
            }
        }
        return res;
    }
    public int findMax1(int i , int j , int[][] grid , int[][] horDp){
        if(i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(horDp[i][j] != -1){
            return horDp[i][j];
        }
        int right = 0;
        if(grid[i][j] == 1){
            right = findMax1(i , j + 1 , grid , horDp) + 1;
        }
        return horDp[i][j] = right;
    }

    public int findMax2(int i , int j , int[][] grid , int[][] verDp){
        if(i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(verDp[i][j] != -1){
            return verDp[i][j];
        }
        int bottom = 0;
        if(grid[i][j] == 1){
            bottom = findMax2(i + 1 , j , grid , verDp) + 1;
        }
        return verDp[i][j] = bottom;
    }
}
