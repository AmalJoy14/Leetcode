class Solution {
    public int minRemoval(int[] nums, int k) {
        int left = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int right = 0 ; right < nums.length ; right++){
            while(nums[right] > k *(long) nums[left]){
                left++;
            }
            min = Math.min(min , left + (nums.length - 1 - right) );
        }
        
        return min;
    }
}
