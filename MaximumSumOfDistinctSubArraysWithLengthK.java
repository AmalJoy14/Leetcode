class Solution {
    long sum = 0, max = 0;
    HashSet<Integer> set = new HashSet<>();

    public long maximumSubarraySum(int[] nums, int k) {
        findNextSubArray( 0, k, nums);
        return max;

    }

    public void findNextSubArray(int start, int k, int[] nums) {
        int left = start, right = start;

        while (right < nums.length) {

            while (left < nums.length && set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            right++;
            if (set.size() > k){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            if (set.size() == k) {
                max = Math.max(sum, max);
            }
            // System.out.println(set);
        }

    }
}
