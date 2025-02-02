class Solution {
    public boolean check(int[] nums) {
        int minidx = -1,min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(min >= nums[i]){
                min = nums[i];
                minidx = i;
                while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
        int i;
        for(i = minidx + 1; i< nums.length ; i++){
            if(nums[i - 1] > nums[i]){
                return false;
            }
        }
        for(int j = 0 ; j < minidx ; j++){
            if(j == 0){
                if(nums[i - 1] > nums[j]){
                    return false;
                }
                continue;
            }
            if(nums[j - 1] > nums[j]){
                return false;
            }
        }
        return true;
    }
}
