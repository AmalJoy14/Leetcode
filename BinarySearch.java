class Solution {
    public int search(int[] nums, int target) {
        
        //Binary Search
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
