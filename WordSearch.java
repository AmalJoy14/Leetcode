class Solution {

    boolean a = false,b = false,c = false,d = false;

    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == start){
                    if (search(board , word , i , j , 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board , String word , int i , int j ,int index){
        if (index == word.length()){
            return true;
        }
        char temp = board[i][j];                      //current element
        char ch = word.charAt(index);
        if (i > 0 && board[i - 1][j] == ch){
            board[i][j] = '0';
            a = search(board , word , i - 1 , j , index + 1);
            board[i][j] = temp;
        }
        if (i < board.length - 1 && board[i + 1][j] == ch){
            board[i][j] = '0';
            b = search(board , word , i + 1 , j , index + 1);
            board[i][j] = temp;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == ch){
            board[i][j] = '0';
            c = search(board , word , i , j + 1 , index + 1);
            board[i][j] = temp;
        }
        if (j > 0 && board[i][j - 1] == ch){
            board[i][j] = '0';
            d = search(board , word , i , j - 1 , index + 1);
            board[i][j] = temp;
        }
        return a || b || c || d;
        
    }
}
