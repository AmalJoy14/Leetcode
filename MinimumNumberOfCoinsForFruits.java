class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][1001];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return findMin(prices , 0 , 0 , dp);
    }
    public int findMin(int[] prices , int i , int skip, int[][] dp){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][skip] != -1){
            return dp[i][skip];
        }
        int buy = Integer.MAX_VALUE , notbuy = Integer.MAX_VALUE;
        buy = findMin(prices , i + 1 , i + 1 , dp) + prices[i];
        if(skip > 0){
            notbuy = findMin(prices , i + 1 , skip - 1 , dp);
        }
        return dp[i][skip] = Math.min(buy , notbuy);
    }
}
