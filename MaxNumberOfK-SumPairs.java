class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                if (map.containsKey(k - nums[i])) {
                    res++;
                    map.put(k - nums[i], map.get(k - nums[i]) - 1);
                    if (map.get(k - nums[i]) == 0) {
                        map.remove(k - nums[i]);
                    }
                }
            }

        }
        return res;
    }
}
