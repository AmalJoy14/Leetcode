class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[] rowServers = new int[m];
        int[] colServers = new int[n];
        ArrayList<int[]> list = new ArrayList<>();
        int total = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                if(grid[i][j] == 1){
                    rowServers[i]++;
                    colServers[j]++;
                    list.add(new int[]{i , j});
                    total++;
                }
            }
        }
        int notCommunicate = 0;
        for(int k = 0 ; k < list.size() ; k++){
            int[] temp = list.get(k);
            int i = temp[0];
            int j = temp[1];
            if(rowServers[i] == 1 && colServers[j] == 1){
                notCommunicate++;
            }
        }
        return total - notCommunicate;
    }
}
