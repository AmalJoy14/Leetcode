class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1, flag = 0;
        int size = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i - 1] > nums[i]){
                size = flag == -1 ? size + 1 : 2;
                flag = -1;
            }
            else if(nums[i - 1] < nums[i]){
                size = flag == 1 ? size + 1 : 2;
                flag = 1;
            }
            else{
                flag = 0;
                size = 1;
            }
            res = Math.max(res , size);
        }
        return res;
    }
}
