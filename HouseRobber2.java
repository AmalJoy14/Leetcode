class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int take = 0 , nottake = 0;
        for(int i = 1 ; i < nums.length - 1 ; i++){
            take = nums[i] + dp[i - 1];
            nottake = dp[i];
            dp[i + 1] = Math.max(take , nottake);
        }
        int fstTaken = Math.max(take,nottake);

        dp[1] = nums[1];
        for(int i = 2 ; i < nums.length ; i++){
            take = nums[i] + dp[i - 2];
            nottake = dp[i - 1];
            dp[i] = Math.max(take , nottake);
        }
        int fstNotTaken = Math.max(take,nottake);
        return Math.max(fstTaken,fstNotTaken );
        
    }
}
