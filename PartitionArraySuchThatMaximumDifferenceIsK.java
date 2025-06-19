class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0 , n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int start = nums[i];
            int end = nums[i];
            int j;
            for(j = i ; j < n && nums[j] - start <= k; j++){
                end = nums[j];
            }
            res++;
            i = j - 1;
        }
        return res;
    }
}
