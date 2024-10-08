// To rotate the matrix by 90 degree ,
//     find the transpose of the matrix.
//     flip the transpose matrix along the vertical line through its centre.

class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        // find the transpose of the matrix.
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ;j++){
                if (i == j || j< i){
                    continue;
                }
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        // flip the transpose matrix along the vertical line through its centre.
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size/2 ;j++){
                int temp = matrix[i][size - j -1];
                matrix[i][size - j -1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //Consider giving an upvote.
    }
}
