class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n - 1 ; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int k = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] != 0){
                if(i != k){
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                k++;
            }
        }
        return nums;
    }
}
