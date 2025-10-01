class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0 , res = 0;
        while(numBottles > 0){
            res += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty -= numBottles * numExchange;
        }
        return res;
    }
}
