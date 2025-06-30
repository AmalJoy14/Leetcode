class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }
        int res = 0;
        for(int num : map.keySet()){
            if(map.containsKey(num - 1)){
                res = Math.max(res , map.get(num) + map.get(num - 1));
            }
            if(map.containsKey(num + 1)){
                res = Math.max(res , map.get(num) + map.get(num + 1));
            }
        }
        return res;
    }
}
