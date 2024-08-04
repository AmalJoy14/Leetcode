class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int x = start ^ goal;
        while (x != 0){
            if (x % 2 == 1){
                count++;
            }
            x = x / 2;
        }
        return count;
    }
}
