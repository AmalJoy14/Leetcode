class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        long sum = 0 , sum2 = 0;
        for(int i = 0 ; i < flips.length ; i++){
            sum += i + 1;
            sum2 += flips[i];
            if(sum == sum2) count++;
        }
        return count;
    }
}
