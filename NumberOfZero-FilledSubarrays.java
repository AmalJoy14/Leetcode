class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, size = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                size++;
            }else{
                res += size * (size + 1) / 2;
                size = 0;
            }
        }
        res += size * (size + 1) / 2;
        return res;
    }
}
