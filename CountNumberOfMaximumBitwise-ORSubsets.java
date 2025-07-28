class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = max | num;
        }
        return findCount(nums , 0 , 0 , max);
    }
    public int findCount(int[] nums , int i , int bitor , int max){
        if(i == nums.length || bitor > max){
            if(bitor == max) return 1;
            return 0;
        }
        int take = findCount(nums, i + 1 , bitor | nums[i] , max);
        int nottake = findCount(nums , i + 1 , bitor , max);
        return take + nottake;
    }
}
