class Solution {
    public boolean checkDivisibility(int n) {
        int num = n, sum = 0, prd = 1;
        while(num != 0){
            int rem = num % 10;
            num /= 10;
            sum += rem;
            prd = prd * rem;
        }
        return n % (sum + prd) == 0;
    }
}
