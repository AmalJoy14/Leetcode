class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int flag1 = 0 , flag2 = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) flag1 = 1;
                    if(j == 0) flag2 = 1;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        
        for(int i = 1 ; i < n ; i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i] , 0);
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(flag2 != 1 && i == 0) continue;
            if(matrix[0][i] == 0){
                for(int j = 0 ; j < n ; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(flag1 == 1) Arrays.fill(matrix[0] , 0);
    }
}
