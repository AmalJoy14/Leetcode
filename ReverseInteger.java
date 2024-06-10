class Solution {
    public int reverse(int x) {
        int isNegative = 0, rem;
        long rev = 0;
        if (x < 0){
            x = Math.abs(x);
            isNegative = 1;
        }

        while(x > 0){
            rem = x%10;
            rev = rev * 10 + rem;
            x = x/10;
        }

        if (isNegative == 1){
            rev = -(rev);
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
            rev = 0;
        }
    return (int)rev;
    }
}
