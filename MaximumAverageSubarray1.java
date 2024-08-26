class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE, sum = 0;
        int j;
        for (int i = 0 ; i < k ; i++){
            sum += nums[i];
        }
        if (sum/k > max){
            max = sum/k;
        }
        for (int i = 1 ; i + k - 1 < nums.length ; i++){
            j = i + k - 1;
            sum -= nums[i - 1];
            sum += nums[j];
            if (sum/k > max){
                max = sum/k;
            }
        }
        return max;
    }
}
