class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++){
            map.add(nums[i]);
        }
        int count = 0;
        for (int e : map){
            if (e < k){
                return -1;
            }
            else if (e > k){
                count++;
            }
        }
        return count;
    }
}
