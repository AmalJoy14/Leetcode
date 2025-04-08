class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0 , sum = 0;
        for(int val : gain){
            sum += val;
            res = Math.max(res , sum);
        }
        return res;
    }
}
