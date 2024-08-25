class Solution {
    public int missingNumber(int[] nums) {
        int actual = 0, need = 0;
        int i;
        for (i = 0 ; i < nums.length ; i++){
            need = need + i;
            actual = actual + nums[i];
        }
        need = need + i;
        return need - actual;
    }
}
