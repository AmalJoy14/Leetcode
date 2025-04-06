class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[][] dp = new List[n][n + 1];  // Store result subsets

        return helper(nums, 0, -1, dp);
    }

    private List<Integer> helper(int[] nums, int i, int prevIndex, List<Integer>[][] dp) {
        if (i == nums.length) return new ArrayList<>();

        if (dp[i][prevIndex + 1] != null) {
            return dp[i][prevIndex + 1];
        }

        List<Integer> take = new ArrayList<>();
        if (prevIndex == -1 || nums[i] % nums[prevIndex] == 0) {
            take = new ArrayList<>(helper(nums, i + 1, i, dp));
            take.add(0, nums[i]);
        }

        List<Integer> skip = helper(nums, i + 1, prevIndex, dp);

        dp[i][prevIndex + 1] = (take.size() > skip.size()) ? take : skip;
        return dp[i][prevIndex + 1];
    }
}
