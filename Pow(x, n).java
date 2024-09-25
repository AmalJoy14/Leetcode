class Solution {
    public double myPow(double x, int m) {
        long n = m;
         
        if (n == 0) return 1;

        if (n < 0){                 //Since x^-n  =>  (1 / x)^n
            n = -n;
            x = 1 / x;
        }
         

        double res = 1;

        while (n != 0){
            long rem = n % 2;
            n = n / 2;
            if (rem == 1){
                res = res * x;
            }
            x = x * x;
        }
        return res;
    }
}
