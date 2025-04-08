class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sumArr = new int[n + 1];
        int sum = 0;
        for(int i = n - 1; i >= 0 ; i--){
            sum += nums[i];
            sumArr[i] = sum;
        }
        sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(sumArr[i + 1] == sum){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
