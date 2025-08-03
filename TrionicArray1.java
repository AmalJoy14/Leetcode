class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        for(int i = 1 ; i < n - 1 ; i++){
            for(int j = i + 1 ; j < n - 1 ; j++){
                if(isTrionic(nums , i , j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTrionic(int[] nums , int p , int q){
        for(int i = 0 ; i <= p ; i++){
            if(i + 1 <= p && nums[i + 1] <= nums[i]){
                return false;
            }
        }
        for(int i = p ; i <= q ; i++){
            if(i + 1 <= q && nums[i + 1] >= nums[i]){
                return false;
            }
        }
        for(int i = q ; i < nums.length ; i++){
            if(i + 1 <= nums.length - 1 && nums[i + 1] <= nums[i]){
                return false;
            }
        }
        return true;
    }
}
