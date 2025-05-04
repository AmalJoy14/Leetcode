class Solution {
    public int maxProduct(int n) {
        int res = 0;
        
        while(n!= 0){
            int rem1 = n % 10;
            n = n / 10;
            int temp = n;
            while(temp != 0){
                int rem2 = temp % 10;
                temp /= 10;
                res = Math.max (res , (int)(rem1 * rem2));
            }
        }
        return res;
    }
}
