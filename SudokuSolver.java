class Solution {

    public void solveSudoku(char[][] board) {
        solver(0, 0, board);
    }

    public boolean solver(int row, int col, char[][] board) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solver(row + 1, 0, board);
        }

        if (board[row][col] != '.') {
            if (solver(row, col + 1, board)){
                return true;
            }
        }
        else {
            for (char val = '9'; val >= '1'; val--) {
                if (isSafe(val, row, col, board)) {
                    
                    board[row][col] = val;

                    if (solver(row, col + 1, board)){
                        return true;
                    }
                    
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char val, int row , int col , char[][] board){
        //Horizontal check
        for (int i = 0 ; i < 9 ; i++){
            if (board[row][i] == val){
                return false;
            }
        }

        //Vertical check
        for (int i = 0 ; i < 9 ; i++){
            if (board[i][col] == val){
                return false;
            }
        }

        //3*3 block check;
        int i = row, j = col;
        while(i % 3 != 0) i--;
        while(j % 3 != 0) j--;
        for (int m = i ; m < i + 3 ; m++){
            for (int n = j ; n < j + 3 ; n++){
                if (board[m][n] == val){
                    return false;
                }
            }
        }
        return true;
    }

}
