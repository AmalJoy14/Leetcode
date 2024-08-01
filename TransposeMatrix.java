class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][]transpose = new int[col][row];

        // find the transpose of the matrix.
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
