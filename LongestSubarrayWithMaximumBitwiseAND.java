class Solution {
    public int longestSubarray(int[] nums) {
        int res = 1 , size = 1 , max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , nums[i]);
        }
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == max && nums[i] == nums[i - 1]){
                size++;
            }
            else{
                size = 1;
            }
            res = Math.max(res , size);   
        }
        return res;
    }
}
