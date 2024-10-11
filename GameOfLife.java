class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                int alive = 0;
                
                //Searching.....
                if (i != 0){
                    if (board[i-1][j] == 1){
                        alive++;
                    }
                    if (j != 0 && board[i-1][j-1] == 1){
                        alive++;
                    }
                    if (j != board[0].length - 1 && board[i-1][j+1] == 1){
                        alive++;
                    }
                }
                if (i != board.length - 1){
                    if (board[i+1][j] == 1){
                        alive++;
                    }
                    if (j != 0 && board[i+1][j-1] == 1){
                        alive++;
                    }
                    if (j != board[0].length - 1 && board[i+1][j+1] == 1){
                        alive++;
                    }
                }
                if (j != 0 && board[i][j-1] == 1){
                    alive++;
                }
                if (j != board[0].length - 1 && board[i][j+1] == 1){
                    alive++;
                }

                //results...
                if (alive < 2 || alive > 3){
                    res[i][j] = 0;
                }
                else if (alive == 3){
                    res[i][j] = 1;
                }
                else if (board[i][j] == 1 && alive == 2){
                    res[i][j] = 1;
                }
            }

            
        }

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                board[i][j] = res[i][j];
            }
        }
    }
}
