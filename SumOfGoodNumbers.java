class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i - k >= 0){
                if(nums[i - k] >= nums[i]){
                    continue;
                }
            }
            if(i + k < nums.length){
                if(nums[i + k] >= nums[i]){
                    continue;
                }
            }
            sum += nums[i];
        }
        return sum;
    }
}
