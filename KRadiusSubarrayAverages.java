class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length , idx = k;
        if(k == 0) return nums;
        int[] res = new int[n];
        Arrays.fill(res , -1);
        int left = 0 , div = 2 * k;
        long sum = 0;
        for(int right = 0 ; right < n ; right++){
            sum += nums[right];
            if(right - left >= div){
                res[idx++] = (int)(sum / (div + 1));
                sum -= nums[left];
                left++;
                
            }
        }
        return res;
    }
}
