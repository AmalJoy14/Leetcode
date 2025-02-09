class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long goodPairs = 0;
        HashMap<Integer , Long> map = new HashMap<>();
        for(int i = (int)n - 1; i >= 0 ; i--){
            goodPairs += map.getOrDefault(nums[i] - i, 0L);
            map.put(nums[i] - i , map.getOrDefault(nums[i] - i, 0L) + 1);
        }
        return (long)(n * (n - 1) / 2 - goodPairs);
    }
}
