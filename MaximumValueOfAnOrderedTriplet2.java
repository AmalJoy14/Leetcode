class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int max = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            max = Math.max(max , nums[i]);
            pre[i] = max;
        }
        int left = 0;
        long res = 0;
        for(int right = 1 ; right < n - 1; right++){
            if(nums[right] >= nums[left]){
                left = right;
                continue;
            }
            res = Math.max(res , (nums[left] - nums[right]) * (long)pre[right + 1]);
        }
        return res;
    }
}
