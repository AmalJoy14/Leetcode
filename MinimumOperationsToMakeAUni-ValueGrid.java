class Solution {
    public int minOperations(int[][] grid, int x) {
        int median = 0;
        int n = grid.length , m = grid[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        median = list.get(list.size() / 2);
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int rem = (median - grid[i][j]) % x;
                if(rem != 0) return -1;
                count += Math.abs(median - grid[i][j]) / x;
            }
        }
        return count;
    }
}
