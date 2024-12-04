class Solution {
    public void solve(char[][] board) {
        int m = board.length , n = board[0].length;
        for (int i = 0 ; i < n ; i++){
            if (board[0][i] == 'O'){
                findEdgeRegion(0 , i , board);
            }
            if (board[m - 1][i] == 'O'){
                findEdgeRegion(m - 1 , i , board);
            }
        }
        for (int i = 0 ; i < m ; i++){
            if (board[i][0] == 'O'){
                findEdgeRegion(i , 0 , board);
            }
            if (board[i][n - 1] == 'O'){
                findEdgeRegion(i , n - 1 , board);
            }
        }
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j ++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void findEdgeRegion(int i , int j , char[][] board){
        if (board[i][j] == 'X' || board[i][j] == 'E'){
            return;
        }
        board[i][j] = 'E';

        //Top
        if (i > 0)  findEdgeRegion(i - 1, j , board);
        //Bottom
        if (i < board.length - 1) findEdgeRegion(i + 1, j , board);
        //Left
        if (j > 0 ) findEdgeRegion(i, j - 1 , board);
        //Right
        if (j < board[0].length - 1) findEdgeRegion(i, j + 1 , board);
    }
}
