class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        List<Map<Integer , Integer>> dp = new ArrayList<>();
        for(int i = 0 ;i < nums.length ; i++){
            dp.add(i , new HashMap<>());
        }
        return findWays(nums , 0 , 0 , target , dp);
    }

    public int findWays(int[] nums , int idx, int sum , int target , List<Map<Integer , Integer>> dp){
        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }
        if(dp.get(idx).containsKey(sum)){
            return dp.get(idx).get(sum);
        }
        int plus = findWays(nums , idx + 1 , sum + nums[idx] , target , dp);
        int minus = findWays(nums , idx + 1 , sum - nums[idx] , target , dp);

        dp.get(idx).put(sum , plus + minus);
        return plus + minus;
    }
}
