class Solution {
    public long sumAndMultiply(int n) {
        long res = 0;
        long sum = 0;
        long mul = 1;
        while(n != 0){
            long rem = n % 10;
            sum += rem;
            n /= 10;
            if(rem != 0){
                res += mul * rem;
                mul *= 10;
            }
        }
        return res * sum;
    }
}
