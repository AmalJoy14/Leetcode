class Solution {
    public long maximumMedianSum(int[] nums) {
        long res = 0;
        Arrays.sort(nums);
        int left = 0 , right = nums.length - 1;
        while(left < right){
            left++;
            right--;
            res += nums[right];
            right--;
        }
        return res;
    }
}
