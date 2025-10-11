class Solution {
    public int longestSubarray(int[] nums) {
        int res = 2;
        long sum = 0;
        int size = 2;
        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i - 1] + nums[i - 2] == nums[i]){
                size++;
            }else{
                size = 2;
            }
            res = Math.max(res , size);
        }
        return res;
    }
}
