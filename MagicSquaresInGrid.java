class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        int m = grid.length , n = grid[0].length;
        if(m < 3 || n < 3) return 0;

        for(int i = 0 ; i < m - 2 ; i++){
            for(int j = 0 ; j < n - 2 ; j++){

                int[] arr = new int[16];
                for(int p = i ; p < i + 3 ; p++){
                    for(int q = j ; q < j + 3 ; q++){
                        arr[grid[p][q]]++;
                    }
                }
                //System.out.println(Arrays.toString(arr));
                int flag = 1;
                for(int k = 1 ; k < 16 ; k++){
                    if(k > 9 && arr[k] > 0){
                        flag = 0;
                        break;        
                    }else if(k <= 9 && arr[k] != 1){
                        flag = 0;
                        break;
                    }
                }
                
                if(flag == 0) continue;
                
                int col1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                int col2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                int col3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

                int row1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int row2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                int row3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                int diag1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int diag2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
                
                if(col1 == col2 && col2 == col3 && col3 == row1 && row1 == row2 && row2 == row3 && row3 == diag1 && diag1 == diag2){
                    res++;
                }
            }
        }
        return res;
    }
}
