class Solution {
    public int findMin(int[] nums) {
        //edge case
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2)
            return nums[0] > nums[1] ? nums[1] : nums[0];

 
        int left = 0 , right = nums.length - 1;
        while(left + 1 != right){
            int mid = (left + right)/2;
            if (nums[mid] > nums[right]){
                left = mid;
            }
            else if (nums[mid] < nums[left]){
                right = mid;
            }
            else{
                return nums[0];
            }
        }
        return nums[right];
    }
}
