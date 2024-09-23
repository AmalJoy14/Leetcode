class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set1 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (set1.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    set1.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            HashSet<Character> set2 = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (set2.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    set2.add(board[i][j]);
                }
            }
        }
        ////////////////
        for (int i = 2; i < 9; i += 3) {

            for (int j = 2; j < 9; j += 3) {
                HashSet<Character> set3 = new HashSet<>();
                for (int n = i - 2 ; n <= i ; n++){
                    
                    for (int m = j - 2 ; m <= j ; m++) {
                        if (set3.contains(board[n][m])) {
                            // System.out.println("Yooo");
                            return false;
                        } else if (board[n][m] != '.') {
                            // System.out.println("????");
                            set3.add(board[n][m]);
                        }
                    }
                     
                }
                // System.out.println(set3);
               
            }
        }

        return true;
    }
}
