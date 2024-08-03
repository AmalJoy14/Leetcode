class Solution {
    public int countBinary(int num){
        int count = 0;
        while (num != 0){
            num = num / 2;
            count++;
        }
        return count;
    }
    public boolean isPowerOfFour(int n) {
        int count = countBinary(n);
        if ( (n & n-1) == 0 && count%2 != 0){
            return true;
        } else {
            return false;
        }
    }
}
