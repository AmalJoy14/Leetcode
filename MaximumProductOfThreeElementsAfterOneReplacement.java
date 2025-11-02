class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);
        long max1 = nums[n - 1];
        long max2 = nums[n - 2];
        long max3 = 100000;
        return max1 * max2 * max3;
    }
}
