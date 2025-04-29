class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0;
        for(int num : nums){
            max = Math.max(max , num);
        }
        int left = 0 , count = 0;
        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] == max) count++;

            while(count == k){
                //System.out.println(left + " " + right);
                res += nums.length - right;
                if(nums[left] == max) count--;
                left++;
            }
        }
        return res;
    }
}
