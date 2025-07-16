class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][1002];
        for(int[] num : dp){
            Arrays.fill(num , -1);
        }
        return findMax(prices , 0 , -1 , dp);
    }

    public int findMax(int[] prices , int idx , int buyprice , int[][] dp){
        if(idx >= prices.length){
            return 0;
        }
        if(dp[idx][buyprice + 1] != -1){
            return dp[idx][buyprice + 1];
        }
        int sell = 0 , buy = 0 , skip = 0;
        if(buyprice != -1 && prices[idx] > buyprice){
            sell = findMax(prices , idx + 2 , -1 , dp) + (prices[idx] - buyprice);
        }
        if(buyprice == -1){
            buy = findMax(prices , idx + 1 , prices[idx] , dp);
        }
        skip = findMax(prices , idx + 1 , buyprice , dp);

        return dp[idx][buyprice + 1] = Math.max(Math.max(buy , sell) , skip);
    }
}
