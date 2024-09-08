class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();  //start,count
        for (int i = 0 ; i < nums.length ; i++){
            if (!set.contains(nums[i]-1)){
                map.put(nums[i] , 1);
            }
        }
        int max = 0;
        for (int key : map.keySet()){
            int len = 0;
            while (set.contains(key)){
                len++;
                key++;
            }
            if (max < len) max = len;
        }
        
        return max;
    }
}
