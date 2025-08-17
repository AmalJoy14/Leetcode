class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries){
            int idx = query[0];
            while(idx <= query[1]){
                nums[idx] = (int)((nums[idx] * (long)query[3]) % 1_000_000_007);
                idx += query[2];
            }
        }
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}
