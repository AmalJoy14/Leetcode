class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];

        int[] arr = new int[n*n + 1];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                arr[grid[i][j]]++;
                if (arr[grid[i][j]] == 2){
                    res[0] = grid[i][j];
                }
            }
        }
        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] == 0){
                res[1] = i;
            }
        }
        return res;
    }
}
