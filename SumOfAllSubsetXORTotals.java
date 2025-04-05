class Solution {
    public int subsetXORSum(int[] nums) {
        int x = 0;
        for (int i = 0 ; i< nums.length ; i++){
            x = x | nums[i];
        }
        return x * (int)Math.pow(2 , nums.length - 1);
    }
}
