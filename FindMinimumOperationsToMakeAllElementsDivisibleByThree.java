class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for(int num : nums){
            res += num % 3 == 0 ? 0 : 1;
        }
        return res;
    }
}
