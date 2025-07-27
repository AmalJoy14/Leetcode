class Solution {
    public int countHillValley(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            int j = i - 1, k = i + 1;
            while(j >= 0 && nums[j] == nums[i]){
                j--;
            }
            while(k < nums.length && nums[k] == nums[i]){
                k++;
            }
            if(j >= 0 && k < nums.length){
                if(nums[j] > nums[i] && nums[i] < nums[k] || nums[j] < nums[i] && nums[i] > nums[k]){
                    res++;
                }
            }
        }
        return res;
    }
}
