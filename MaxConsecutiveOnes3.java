class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0 , count = 0;
        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] == 0){
                count++;
            }
            
            while(k < count){
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
            
            res = Math.max(res , right - left + 1);
        }
        return res;
    }
}
