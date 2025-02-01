class Solution {
    public int maxFrequency(int[] nums, int k) {
        int countK = 0 ;
        for(int e : nums){
            if(e == k) countK++;
        }
        int currMax = 0;
        for(int n = 1 ; n <= 50; n++ ){
            int curr = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] == n) curr++;
                if(nums[i] == k) curr--;
                if(curr < 0) curr = 0;
                currMax = Math.max(currMax , curr); 
            }
        }
        return currMax + countK;
    }
}
