class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        int n = nums.length , limit = Math.min(k , n - k + 1);
        long[] prefix = new long[n + 1];
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            prefix[i + 1] = sum;
        }
        for(int i = 0 ; i < limit ; i++){
            sum = prefix[i + k] - prefix[i];
            for(int j = i + k ; j + k <= n ; j += k){
                long curr = prefix[j + k] - prefix[j];
                //System.out.println(sum + " " + curr);
                res = Math.max(res , sum);
                sum = Math.max(curr , sum + curr);
            }
            res = Math.max(res , sum);
        }
        return res;
    }
}
