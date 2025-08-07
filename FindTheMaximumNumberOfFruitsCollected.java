class Solution {
    int n;
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length ;
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += fruits[i][i];
            fruits[i][i] = 0;
        }
        long[][] dp = new long[n][n];
        for(long[] arr : dp) Arrays.fill(arr , -1);
        sum += findMax1(fruits , n - 1 , 0 , dp);
        for(long[] arr : dp) Arrays.fill(arr , -1);
        sum += findMax2(fruits , 0 , n - 1 , dp);
        return (int)sum;
    }
    public long findMax1(int[][] fruits , int i , int j , long[][] dp){
        if(i == n - 1 && j == n - 1) return 0;
        if(i >= n || i < 0 || j >= n) return Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        long right = Integer.MIN_VALUE , topRight = Integer.MIN_VALUE , bottomRight = Integer.MIN_VALUE;
        right = findMax1(fruits , i , j + 1 , dp);
        topRight = findMax1(fruits , i - 1 , j + 1 ,dp);
        bottomRight = findMax1(fruits , i + 1 , j + 1 ,dp);

        return dp[i][j] = Math.max(right , Math.max(topRight , bottomRight)) + fruits[i][j];
    }
    public long findMax2(int[][] fruits , int i , int j , long[][] dp){
        if(i == n - 1 && j == n - 1) return 0;
        if(j < 0 || j >= n || i >= n) return Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        long bottom = Integer.MIN_VALUE , bottomLeft = Integer.MIN_VALUE , bottomRight = Integer.MIN_VALUE;

        bottom = findMax2(fruits , i + 1 , j , dp);
        bottomRight = findMax2(fruits , i + 1 , j + 1 ,dp);
        bottomLeft = findMax2(fruits , i + 1 , j - 1 ,dp);

        return dp[i][j] = Math.max(bottom , Math.max(bottomLeft , bottomRight)) + fruits[i][j];
    }
}
