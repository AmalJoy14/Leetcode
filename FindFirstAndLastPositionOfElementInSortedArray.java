class Solution {
    public int[] findRange(int[] nums, int index){
        int left = index, right = index;
        while(left != 0 && nums[left - 1] == nums[left]){
            left--;
        }
        while(right != nums.length - 1 && nums[right + 1] == nums[right]){
            right++;
        }
        return new int[]{left, right};
    }
    public int[] searchRange(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (target == nums[mid]){
                return findRange(nums , mid);
            } else if (target > nums[mid]){
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
