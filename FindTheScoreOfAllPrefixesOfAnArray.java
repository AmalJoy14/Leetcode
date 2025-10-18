class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        long max = 0 , sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , nums[i]);
            long cover = max + nums[i];
            sum += cover;
            res[i] = sum;
        }
        return res;
    }
}
