class Solution {
    public int maximumPossibleSize(int[] nums) {
        int rem = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i - 1] > nums[i] ){
                rem++;
                nums[i] = nums[i - 1];
            }
        }
        return nums.length - rem;
    }
}
