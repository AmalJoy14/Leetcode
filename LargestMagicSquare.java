class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length , n =grid[0].length;
        int[][] rowSum = new int[m + 1][n + 1];
        int[][] colSum = new int[m + 1][n + 1];
        int[][] diag1Sum = new int[m + 1][n + 1];
        int[][] diag2Sum = new int[m +1 ][n +1 ];

        for(int i = 1 ; i <= m ; i++){
            int sum = 0;
            for(int j = 1 ; j <= n ; j++){
                sum += grid[i - 1][j - 1];
                rowSum[i][j] = sum;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            int sum = 0;
            for(int j = 1 ; j <= m ; j++){
                sum += grid[j - 1][i - 1];
                colSum[j][i] = sum;
            }
        }
        int max = Math.min(m , n) - 1;
        while(max >= 1){
            for(int i = 1 ; i <= m ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(isPossible(rowSum , colSum , i , j , max , grid)){
                        return max + 1;
                    }
                }
            }
            max--;
        }
        return 1;
    }
    public boolean isPossible(int[][] rowSum , int[][] colSum , int r , int c , int max , int[][] grid){
        int m = rowSum.length, n = rowSum[0].length;
        if(r + max >= m || c + max >= n) return false;
        int sum = rowSum[r][c + max] - rowSum[r][c - 1];
        int diag1 = 0 , diag2 = 0;
        for(int i = 0 ; i <= max ; i++){
            if(rowSum[r + i][c + max] - rowSum[r + i][c - 1] != sum) return false;
            if(colSum[r + max][c + i] - colSum[r - 1][c + i] != sum) return false;
            diag1 += grid[r + i - 1][c + i - 1];
            diag2 += grid[r + i - 1][c + max - i - 1];
        }
        if(diag1 != sum || diag2 != sum) return false;
        return true;
    }
}
