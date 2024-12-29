class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int count = 0;
        for (int i = 0 ; i < n ; i++){
            int max = grid[0][i];
            for (int j = 1 ; j < m ; j++){
                // System.out.println(grid[j][i]);
                if(max >= grid[j][i]){
                    count+= max - grid[j][i] + 1;
                    grid[j][i] = max + 1;
                    // System.out.println("count" + count);
                    
                }
                max = grid[j][i];
            }
            // System.out.println();
        }

        return count;
    }
}
