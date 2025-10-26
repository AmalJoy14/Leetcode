class Solution {
    public long removeZeros(long n) {
        long res = 0;
        while(n != 0){
            long rem = n % 10;
            n = n / 10;
            if(rem != 0){
                res = res * 10 + rem;
            }
        }
        long mainres = 0;
        while(res != 0){
            long rem = res % 10;
            res /= 10;
            mainres = mainres * 10 + rem;
        }
        return mainres;
    }
}
