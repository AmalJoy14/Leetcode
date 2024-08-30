public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int val = 0;
        for (int i = 31; i >= 0 ; i--){
            int left = (n >> i) & 1;
            val = val | (left << (31 - i));
        }
        return val;
    }
}
