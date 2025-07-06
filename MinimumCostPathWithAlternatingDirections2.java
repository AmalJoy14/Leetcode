class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        long[][] dp = new long[m][n];
        for(long[] arr : dp){
            Arrays.fill(arr , -1);
        }
        long res = findCost(0 , 0 ,1 , waitCost , dp) + 1;
        return res;
    }

    public long findCost(int i , int j ,int sec , int[][] waitCost , long[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == waitCost.length - 1 && j == waitCost[0].length - 1){
            return 0;
        }
        long bottom = Long.MAX_VALUE , right = Long.MAX_VALUE , wait = Long.MAX_VALUE;
        if(sec % 2 != 0){
            if(i + 1 < waitCost.length){
                bottom = findCost(i + 1 , j , sec + 1 , waitCost , dp) + (i + 2) * ( j + 1);
            }
            if(j + 1 < waitCost[0].length){
                right = findCost(i , j + 1 , sec + 1 , waitCost , dp) + (i + 1) * ( j + 2);
            }
        }
        else{
            wait = findCost(i , j , sec + 1 , waitCost , dp) + waitCost[i][j];
        }
        return dp[i][j] = Math.min(wait , Math.min(bottom , right));
    }
}
