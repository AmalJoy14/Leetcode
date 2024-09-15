class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        int[] res = new int[2];
        int k = 0;

        for (int i = 0 ; i < nums.length ; i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }
}
