class Solution {
    public int maxSumDivThree(int[] nums) {
        long[][] dp = new long[nums.length][3];
        for(long[] arr : dp){
            Arrays.fill(arr , Long.MIN_VALUE);
        }
        return (int)findMax(0 , nums , 0 ,dp);
    }
    public long findMax(int idx , int[] nums , int rem, long[][] dp){
        if(idx == nums.length){
            if(rem == 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[idx][rem] != Long.MIN_VALUE){
            return dp[idx][rem];
        }
        long take = 0 , nottake = 0;
        take = findMax(idx + 1 , nums , (rem + nums[idx] % 3)%3 ,dp) + nums[idx];
        nottake = findMax(idx + 1 , nums , rem, dp);
        return dp[idx][rem] = Math.max(take , nottake);
    }
}
