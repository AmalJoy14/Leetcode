class Solution {
    public int minimizeMax(int[] nums, int p) {
        int res = 0 , n = nums.length;
        Arrays.sort(nums);
        int left = 0 , right = nums[n - 1] - nums[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(countLesser(mid , nums) >= p){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }

    public int countLesser(int mid , int[] nums){
        int count = 0;
        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i + 1] - nums[i] <= mid){
                count++;
                i++;
            }
        }
        return count;
    }
}
