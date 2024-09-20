class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        /***********Kadane's Algorithm***************/
        for (int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if (sum < 0){
                sum = 0;
            }
        }

        
        return max;
    }
}
