class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , i);
        }
        for(int i = 0 ; i < operations.length ; i++){
            int val1 = operations[i][0];
            int val2 = operations[i][1];
            nums[map.get(val1)] = val2;
            map.put(val2 , map.get(val1));
        }
        return nums;
    }
}
