class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int len = 0, rem = 0;
        while(len <= 1000000){
            rem = (rem * 10 + 1) % k;
            len++;
            if(rem == 0) return len;
        }
        return -1;
    }
}
