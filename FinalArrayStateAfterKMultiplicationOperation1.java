class Solution {
    public int min(int[] nums){
        int index = 0,min = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] < min){
                min = nums[i];
                index = i;
            }
        }
        return index;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (k == 0 || nums.length == 0) return nums;
        int indexMin;
        for (int i = 0 ; i < k ; i++ ){
            indexMin = min(nums);
            nums[indexMin] *= multiplier;
        }
        return nums;
    }
}
