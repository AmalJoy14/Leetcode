class Solution {
    List<List<String>> list = new ArrayList<>();
    //Add the N Queens in n rows.
    public List<List<String>> solveNQueens(int n) {
        List<String> sub =  new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            sub.add(".".repeat(n));
        }
        findPossibleSolution(n ,0 , sub);
        return list;
    }

    public void findPossibleSolution(int n ,int row, List<String> sub){
        if (row == n){
            list.add(new ArrayList<>(sub));
            return;
        }
        for (int col = 0 ; col < n ; col++){
            if (isSafe(n , row , col , sub)){
                sub.set(row, ".".repeat(col) + "Q" + ".".repeat(n - col - 1));
                findPossibleSolution(n , row + 1, sub);
                sub.set(row, ".".repeat(n)); //Backtrack
            }
        }
    }

    public boolean isSafe(int n, int row , int col , List<String> sub){
        //Is the column safe till row?
        for (int i = 0 ; i < row ; i++){
            if (sub.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //Is the lef-top diagonal safe ??
        int j = col;
        for (int i = row ; i >= 0 && j >= 0 ; i--){
            if (i != row && sub.get(i).charAt(j) == 'Q'){
                return false;
            }
            j--;
        }

        //Is the right-top diagonal safe ??
        j = col;
        for (int i = row ; i >= 0 && j < n ; i--){
            if (i != row && sub.get(i).charAt(j) == 'Q'){
                return false;
            }
            j++;
        }
        return true;
    }

}
