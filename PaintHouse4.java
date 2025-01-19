class Solution {
    public long minCost(int n, int[][] cost) {
        
        int i = 0 , j = n -1;
        long[][][] dp = new long[n][4][4];
        for(int k = 0 ; k < n ; k++){
            for(int l = 0 ; l < 4 ;l++){
                Arrays.fill(dp[k][l] , -1);
            }
        }
        return findCost(-1 , -1,  i , j , cost ,dp);
    }
    public long findCost(int prevleft , int prevright ,int i , int j , int[][] cost ,long[][][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][prevleft + 1][prevright + 1] != -1){
            return dp[i][prevleft + 1][prevright + 1];
        }
        
        long min = Long.MAX_VALUE;;
        for(int p = 0 ; p < 3 ; p++){
            for(int q = 0 ; q < 3 ; q++){
                if(p != q && p != prevleft && q != prevright){
                    long val = findCost(p , q ,i + 1 , j - 1 , cost ,dp) + cost[i][p] + cost[j][q];
                    min = Math.min(min , val);
                }
            }
        }
        dp[i][prevleft + 1][prevright + 1] = min;
        return min;
    }
}
