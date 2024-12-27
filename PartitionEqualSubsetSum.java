class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        
        // If the total sum is odd, it's not possible to partition
        if (target % 2 != 0) return false;
        target /= 2;
        
        // DP array to track possible subset sums
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // A sum of 0 is always possible (by taking no elements)
        
        for (int num : nums) {
            // Iterate backward to prevent overwriting results from the current iteration
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }
        
        return dp[target];  // If we can make the target sum, return true
    }
}
