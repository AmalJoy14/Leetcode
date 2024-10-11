class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int pft = 0;
        int left = 0 ;
        for (int right = 1 ; right < prices.length ; right ++){
            if (prices[right] > prices[left]){
                pft += prices[right] - prices[left];
            }
            left++;
        }
        return pft;
    }
}
