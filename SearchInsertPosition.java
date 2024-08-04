class Solution {
    public int searchInsert(int[] nums, int target) {

        //Binary Search Algorithm
        int left = 0, right = nums.length -1;
        int mid = 0;

        while (left <= right){
            mid =(left + right)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        //////////////////////////////////////////
        if (nums[0] > target) return 0;
        return (left + right)/2 + 1;
    }
}
