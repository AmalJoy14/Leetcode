class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }

            while (1 < count) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            if(count == 1 || (left == 0 && right ==nums.length - 1))
                res = Math.max(res, right - left);
            else
                res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
