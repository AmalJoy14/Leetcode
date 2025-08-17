class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long res = 0 , max = 0;
        int n = prices.length;
        for(int i = 0 ; i < n ; i++){
            max += prices[i] * strategy[i];
        }
        res = max;
        for(int i = 0 ; i < k ; i++){
            if(i < k / 2){
                max += prices[i] * (-1) * strategy[i];
            }else{
                if(strategy[i] == -1)
                    max +=prices[i] + prices[i];
                else if(strategy[i] == 0)
                    max += prices[i];
            }
        }
        res = Math.max(res , max);
        int left = 0;
        for(int right = k ; right < n ; right++){
            if(strategy[right] == -1){
                max += prices[right] * 2;
            }else if(strategy[right] == 0){
                max += prices[right];
            }
            max += prices[left] * strategy[left];
            left++;
            int mid = (left + right) / 2;
            max -= prices[mid];
            res = Math.max(max , res);
        }
        return res;
    }
}
