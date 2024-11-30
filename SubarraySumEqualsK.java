class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //Prefix Sum
        HashMap <Integer,Integer> prefixSum = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            
            if (sum == k){
                count++;
            }
            if (prefixSum.containsKey(sum - k)){
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum , prefixSum.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}
