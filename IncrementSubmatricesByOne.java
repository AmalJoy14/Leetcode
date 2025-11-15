class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for(int[] query : queries){
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            for(int i = r1 ; i <= r2 ; i++){
                for(int j = c1 ; j <= c2 ; j++){
                    res[i][j]++;
                }
            }
        }
        return res;
    }
}
