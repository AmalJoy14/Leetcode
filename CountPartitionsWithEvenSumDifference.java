class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] arr = new int[n];
        int sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            sum += nums[i];
            arr[i] = sum;
        }
        int res = 0;
        int sum2 = 0;
        for(int i = 0 ; i < n - 1; i++){
            sum2 += nums[i];
            if(Math.abs(sum2 - arr[i + 1]) % 2 == 0){
                res++;
            }
        }
        return res;
    }
}
