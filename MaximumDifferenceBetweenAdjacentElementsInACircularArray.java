class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            res = Math.max(res , Math.abs(nums[(i + 1) % nums.length] - nums[i]));
        }
        return res;
    }
}
