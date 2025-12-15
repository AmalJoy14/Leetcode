class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0 , size = 1, adder = 1;
        for(int i = 0 ; i < prices.length ; i++){
            if(i != 0 && prices[i] == prices[i - 1] - 1){
                size++;
            }else{
                size = 1;
            }
            res += size;
        }
        return res;
    }
}
