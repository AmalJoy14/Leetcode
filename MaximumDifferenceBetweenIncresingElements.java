class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1;
        for(int i  = 1 ; i < nums.length ; i++){
            int j = i - 1;
            while(i < nums.length && nums[j] < nums[i]){
                res = Math.max(res , nums[i] - nums[j]);
                i++;
            }
        }
        return res;
    }
}
